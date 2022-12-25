package ga.repin.education.course04.topic01.hw.v6school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentV6 {
    //@Schema(hidden = true)
    //@Schema(readOnly = true)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "faculty_id")
    private FacultyV6 faculty;
    
    public StudentV6(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public FacultyV6 getFaculty() {
        return faculty;
    }
    
    public void setFaculty(FacultyV6 faculty) {
        this.faculty = faculty;
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "StudentV1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentV6 student = (StudentV6) o;
        //return getAge() == student.getAge() &&
        return getName().equals(student.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
    
}

