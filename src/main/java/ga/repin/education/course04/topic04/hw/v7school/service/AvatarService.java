package ga.repin.education.course04.topic04.hw.v7school.service;

import ga.repin.education.course04.topic04.hw.v7school.entity.Avatar;
import ga.repin.education.course04.topic04.hw.v7school.entity.AvatarInfo;
import ga.repin.education.course04.topic04.hw.v7school.entity.Student;
import ga.repin.education.course04.topic04.hw.v7school.repository.AvatarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.List;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.CREATE_NEW;


@Service
@Transactional
public class AvatarService {
    @Value("${student.path.dir}")
    String studentsDir;
    
    private final AvatarRepository avatarRepository;
    private final StudentService studentService;
    private final Logger logger = LoggerFactory.getLogger(AvatarService.class);
    
    public AvatarService(AvatarRepository avatarRepository, StudentService studentService) {
        logger.debug("Service wire with Repository and studentService");
        this.avatarRepository = avatarRepository;
        this.studentService = studentService;
    }
    
    public boolean fileExists(Path path) {
        logger.info("Method fileExists was invoked");
        if (Files.exists(path)) {
            logger.debug("File " + path.toString() + " exists.");
            return true;
        } else {
            logger.error("File " + path.toString() + " not exists.");
            return false;
        }
    }
    
    public List<AvatarInfo> listAvatarInfo(Integer pageNumber, Integer pageSize) {
        logger.info("Method listAvatarInfo was invoked");
        int limit = pageSize !=null ? pageSize : Integer.MAX_VALUE;
        int offset = pageNumber !=null ? (limit * (pageNumber - 1)) : 0 ;
        return avatarRepository.queryListAvatarInfo(offset, limit);
    }
    
    public Avatar findAvatar(long studentId) {
        logger.info("Method findAvatar was invoked");
        Avatar avatar;
        avatar = avatarRepository.findByStudentId(studentId).orElse(null);
        if (avatar == null) {
            logger.error("Avatar record not found for student with ID: " + studentId);
        } else {
            logger.debug("Avatar record found for student with ID: " + studentId);
        }
        return avatar;
    }
    
    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        logger.info("Method uploadAvatar was invoked");
        Student student = studentService.read(studentId);
        if (student == null){
            logger.error("Student with id " + studentId + " not found");
        }
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
        
        Avatar avatar = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setMediaType(file.getContentType());
        avatar.setData(createPreview(filePath));
        
        avatarRepository.save(avatar);
    }
    
    private String getExtension(String fileName) {
        logger.info("Method getExtension was invoked");
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    
    private byte[] createPreview(Path path) throws IOException {
        logger.info("Method createPreview was invoked");
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
