package ga.repin.education.course04.topic04.hw.v7school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avatar {
    @Id
    @GeneratedValue
    private Long id;
    private String filePath, mediaType;
    private long fileSize;
    
    @Lob
    private byte[] data;
    
    @OneToOne
    private Student student;
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Avatar avatar = (Avatar) o;
        return fileSize == avatar.fileSize && Objects.equals(id, avatar.id) && Objects.equals(filePath, avatar.filePath) && Objects.equals(mediaType, avatar.mediaType) && Arrays.equals(data, avatar.data) && Objects.equals(student, avatar.student);
    }
    
    @Override
    public int hashCode() {
        int result = Objects.hash(id, filePath, mediaType, fileSize, student);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
    
    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", fileSize=" + fileSize +
                ", data=" + Arrays.toString(data) +
                ", student=" + student +
                '}';
    }
    
}
