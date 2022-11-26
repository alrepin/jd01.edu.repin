package ga.repin.education.course03.topic02.hw.school.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    
    //@Schema(hidden = true)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String name;
    private String color;
    
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
        Faculty faculty = (Faculty) o;
        //Objects.equals(id, faculty.id) &&
        return Objects.equals(name, faculty.name);
        //  && Objects.equals(color, faculty.color);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }
}
