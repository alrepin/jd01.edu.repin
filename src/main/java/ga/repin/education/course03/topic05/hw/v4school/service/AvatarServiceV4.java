package ga.repin.education.course03.topic05.hw.v4school.service;

import ga.repin.education.course03.topic05.hw.v4school.model.AvatarV4;
import ga.repin.education.course03.topic05.hw.v4school.model.StudentV4;
import ga.repin.education.course03.topic05.hw.v4school.repository.AvatarRepositoryV4;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE_NEW;


@Service
@Transactional
public class AvatarServiceV4 {
    @Value("${student.path.dir}")
    String studentsDir;
    
    private final AvatarRepositoryV4 avatarRepository;
    private final StudentServiceV4 studentService;
    
    public AvatarServiceV4(AvatarRepositoryV4 avatarRepository, StudentServiceV4 studentService) {
        this.avatarRepository = avatarRepository;
        this.studentService = studentService;
    }
    
    public AvatarV4 findAvatar(long studentId) {
        return avatarRepository.findByStudentId(studentId).orElse(null);
    }
    
    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        StudentV4 student = studentService.read(studentId);
        String studentProfilePath = studentsDir + "/" + studentId;
        Path filePath = Path.of(studentProfilePath, "ava." + getExtension(Objects.requireNonNull(file.getOriginalFilename())));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        
        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }
        
        AvatarV4 avatar = avatarRepository.findByStudentId(studentId).orElseGet(AvatarV4::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(createPreview(filePath));
        
        avatarRepository.save(avatar);
    }
    
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    
    private byte[] createPreview(Path path) throws IOException {
        try (InputStream in = Files.newInputStream(path);
             BufferedInputStream bIn = new BufferedInputStream(in, 1024);
             ByteArrayOutputStream bOut = new ByteArrayOutputStream()) {
            BufferedImage image = ImageIO.read(bIn);
            
            int height = image.getHeight() / (image.getWidth() / 100);
            BufferedImage preview = new BufferedImage(100, height, image.getType());
            Graphics2D graphics = preview.createGraphics();
            graphics.drawImage(image, 0, 0, 100, height, null);
            graphics.dispose();
            
            ImageIO.write(preview, getExtension(path.getFileName().toString()), bOut);
            return bOut.toByteArray();
        }
    }
}
