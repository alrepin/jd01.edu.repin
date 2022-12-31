package ga.repin.education.course04.topic04.hw.v7school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentV7 {
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
    private FacultyV7 faculty;
    
    public StudentV7(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public FacultyV7 getFaculty() {
        return faculty;
    }
    
    public void setFaculty(FacultyV7 faculty) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentV7 student = (StudentV7) o;
        //return getAge() == student.getAge() &&
        return getName().equals(student.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
    
}

