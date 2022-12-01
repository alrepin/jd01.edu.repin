package ga.repin.education.course03.topic02.hw.school.controller;

import ga.repin.education.course03.topic02.hw.school.model.StudentV1;
import ga.repin.education.course03.topic02.hw.school.service.StudentServiceV1;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course03.topic02.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDC7B️ StudentV1 store", description = "StudentV1 model CRUD endpoints")
public class StudentControllerV1 {
    private final StudentServiceV1 studentServiceV1;
    
    public StudentControllerV1(StudentServiceV1 studentServiceV1) {
        this.studentServiceV1 = studentServiceV1;
    }
    
    
    @PostMapping
    public ResponseEntity<StudentV1> createStudent(@RequestBody StudentV1 student) {
        StudentV1 result = studentServiceV1.create(student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<StudentV1> readStudentByID(@PathVariable Long id) {
        StudentV1 result = studentServiceV1.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping
    public ResponseEntity<List<StudentV1>> readStudentsOptionalAgeFilter(@RequestParam(value = "age", required = false) Integer age) {
        List<StudentV1> result = new ArrayList<>(studentServiceV1.filter(age));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentV1> updateStudent(@PathVariable long id, @RequestBody StudentV1 student) {
        StudentV1 result = studentServiceV1.update(id, student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentV1> deleteStudent(@PathVariable long id) {
        StudentV1 result = studentServiceV1.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
