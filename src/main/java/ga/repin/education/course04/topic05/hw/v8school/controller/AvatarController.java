package ga.repin.education.course04.topic05.hw.v8school.controller;


import ga.repin.education.course04.topic05.hw.v8school.entity.Avatar;
import ga.repin.education.course04.topic05.hw.v8school.service.AvatarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ga.repin.education.course04.topic05.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDDBC Avatar store", description = "Avatar model endpoints")
public class AvatarController {
    private final AvatarService avatarService;
    
    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }
    
    @Autowired
    HttpServletRequest request;
    
    private final Logger logger = LoggerFactory.getLogger(AvatarController.class);
    
    @PostMapping(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar) throws IOException {
        if (avatar.getSize() > 1024 * 300) {
            return ResponseEntity.badRequest().body("File is too big");
        }
        
        avatarService.uploadAvatar(id, avatar);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/{id}/avatar/preview")
    public ResponseEntity<byte[]> downloadAvatarPreview(@PathVariable Long id) {
        Avatar avatar = avatarService.findAvatar(id);
        String ip = "ip: " + request.getRemoteAddr();
        logger.info(ip);
        if (avatar != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
            headers.setContentLength(avatar.getData().length);
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }
    
    @GetMapping(value = "/{id}/avatar")
    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        
        boolean exists = false;
        Path path = null;
        Avatar avatar = avatarService.findAvatar(id);
        if (avatar != null) {
            path = Path.of(avatar.getFilePath());
            exists = avatarService.fileExists(path);
        }
        if (exists) {
            try (InputStream is = Files.newInputStream(path); OutputStream os = response.getOutputStream()) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType(avatar.getMediaType());
                response.setContentLength((int) avatar.getFileSize());
                is.transferTo(os);
            }
        } else {
            try (InputStream is = InputStream.nullInputStream(); OutputStream os = response.getOutputStream()) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                is.transferTo(os);
            }
        }
        
    }
    
    @GetMapping("/avatar/list")
    public ResponseEntity<List<Map<String,String>>> listAvatarInfo(
            @RequestParam(value = "page", required = false) Integer pageNumber,
            @RequestParam(value = "item-count", required = false) Integer pageSize) {
        if ((pageNumber != null && pageNumber < 1) || (pageSize != null && pageSize < 1) || (pageSize == null && pageNumber != null)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<Map<String,String>> result = new ArrayList<>(avatarService.listAvatarInfo(pageNumber, pageSize));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
