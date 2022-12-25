package ga.repin.education.course04.topic01.hw.v6school.controller;


import ga.repin.education.course04.topic01.hw.v6school.entity.AvatarV6;
import ga.repin.education.course04.topic01.hw.v6school.entity.AvatarInfoV6;
import ga.repin.education.course04.topic01.hw.v6school.service.AvatarServiceV6;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDDBC Avatar store", description = "Avatar model endpoints")
public class AvatarControllerV6 {
    private final AvatarServiceV6 avatarService;
    
    public AvatarControllerV6(AvatarServiceV6 avatarService) {
        this.avatarService = avatarService;
    }
    
    @PostMapping(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar) throws IOException {
        if (avatar.getSize() > 1024 * 300) {
            return ResponseEntity.badRequest().body("File is too big");
        }
        
        avatarService.uploadAvatar(id, avatar);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/{id}/avatar/preview")
    public ResponseEntity<byte[]> downloadAvatar(@PathVariable Long id) {
        AvatarV6 avatar = avatarService.findAvatar(id);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);
        
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }
    
    @GetMapping(value = "/{id}/avatar")
    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        AvatarV6 avatar = avatarService.findAvatar(id);
        
        Path path = Path.of(avatar.getFilePath());
        
        try (InputStream is = Files.newInputStream(path); OutputStream os = response.getOutputStream()) {
            response.setStatus(200);
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int) avatar.getFileSize());
            is.transferTo(os);
        }
    }
    
    @GetMapping("/avatar/list")
    public ResponseEntity<List<AvatarInfoV6>> listAvatarInfo(
            @RequestParam(value = "page", required = false) Integer pageNumber,
            @RequestParam(value = "item-count", required = false) Integer pageSize) {
        if ((pageNumber != null && pageNumber < 1) || (pageSize != null && pageSize < 1) || (pageSize == null && pageNumber != null)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<AvatarInfoV6> result = new ArrayList<>(avatarService.listAvatarInfo(pageNumber, pageSize));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
