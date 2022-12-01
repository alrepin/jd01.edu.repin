package ga.repin.education.course03.topic03.hw.school.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    //@Schema(hidden = true)
    //@Schema(readOnly = true)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    
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
        Student student = (Student) o;
        //return getAge() == student.getAge() &&
        return getName().equals(student.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
    
}

