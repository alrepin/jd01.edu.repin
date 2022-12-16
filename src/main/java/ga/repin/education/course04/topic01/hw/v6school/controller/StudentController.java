package ga.repin.education.course04.topic01.hw.v6school.controller;

import ga.repin.education.course04.topic01.hw.v6school.entity.Faculty;
import ga.repin.education.course04.topic01.hw.v6school.entity.Student;
import ga.repin.education.course04.topic01.hw.v6school.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDC7B️ Student store", description = "Student model CRUD endpoints")
public class StudentController {
    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student result = studentService.create(student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Student> readStudentByID(@PathVariable Long id) {
        Student result = studentService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/faculty")
    public ResponseEntity<Faculty> facultyByStudent(@PathVariable Long id){
        Faculty result = studentService.facultyOfStudentBy(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping ("/search")
    public ResponseEntity<List<Student>> readStudentsOptionalFilters(
            @RequestParam(value = "age", required = false) Integer specificAge,
            @RequestParam(value = "min-age", required = false) Integer minAge,
            @RequestParam(value = "max-age", required = false) Integer maxAge) {
        
        List<Student> result = new ArrayList<>(studentService.filter(specificAge, minAge, maxAge));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
        Student result = studentService.update(id, student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        Student result = studentService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
