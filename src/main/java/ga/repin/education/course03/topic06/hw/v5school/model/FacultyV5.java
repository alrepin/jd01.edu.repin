package ga.repin.education.course03.topic06.hw.v5school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FacultyV5 {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    
    @JsonIgnore
    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private Collection<StudentV5> students;
    
    
    public FacultyV5(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
    
    public Collection<StudentV5> getStudents() {
        return students;
    }
    
    public void setStudents(Collection<StudentV5> students) {
        this.students = students;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyV5 faculty = (FacultyV5) o;
        //Objects.equals(id, faculty.id) &&
        return Objects.equals(name, faculty.name);
        //  && Objects.equals(color, faculty.color);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }
}
