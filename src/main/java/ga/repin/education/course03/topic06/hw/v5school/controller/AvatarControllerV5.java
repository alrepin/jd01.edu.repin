package ga.repin.education.course03.topic06.hw.v5school.controller;


import ga.repin.education.course03.topic06.hw.v5school.model.AvatarV5;
import ga.repin.education.course03.topic06.hw.v5school.service.AvatarServiceV5;
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

import static ga.repin.education.course03.topic06.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDDBC Avatar store", description = "Avatar model endpoints")
public class AvatarControllerV5 {
    private final AvatarServiceV5 avatarService;
    
    public AvatarControllerV5(AvatarServiceV5 avatarService) {
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
        AvatarV5 avatar = avatarService.findAvatar(id);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);
        
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }
    
    @GetMapping(value = "/{id}/avatar")
    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        AvatarV5 avatar = avatarService.findAvatar(id);
        
        Path path = Path.of(avatar.getFilePath());
        
        try (InputStream is = Files.newInputStream(path); OutputStream os = response.getOutputStream()) {
            response.setStatus(200);
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int) avatar.getFileSize());
            is.transferTo(os);
        }
    }
    
    
}
