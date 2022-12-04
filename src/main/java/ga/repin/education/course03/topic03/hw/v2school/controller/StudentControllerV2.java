package ga.repin.education.course03.topic03.hw.v2school.controller;

import ga.repin.education.course03.topic03.hw.v2school.model.StudentV2;
import ga.repin.education.course03.topic03.hw.v2school.service.StudentServiceV2;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course03.topic03.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDC7B️ StudentV2 store", description = "StudentV2 model CRUD endpoints")
public class StudentControllerV2 {
    private final StudentServiceV2 studentServiceV2;
    
    public StudentControllerV2(StudentServiceV2 studentServiceV2) {
        this.studentServiceV2 = studentServiceV2;
    }
    
    
    @PostMapping
    public ResponseEntity<StudentV2> createStudent(@RequestBody StudentV2 student) {
        StudentV2 result = studentServiceV2.create(student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<StudentV2> readStudentByID(@PathVariable Long id) {
        StudentV2 result = studentServiceV2.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping
    public ResponseEntity<List<StudentV2>> readStudentsOptionalAgeFilter(@RequestParam(value = "age", required = false) Integer age) {
        List<StudentV2> result = new ArrayList<>(studentServiceV2.filter(age));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentV2> updateStudent(@PathVariable long id, @RequestBody StudentV2 student) {
        StudentV2 result = studentServiceV2.update(id, student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentV2> deleteStudent(@PathVariable long id) {
        StudentV2 result = studentServiceV2.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
