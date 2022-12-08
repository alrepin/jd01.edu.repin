package ga.repin.education.course03.topic04.hw.v3school.controller;

import ga.repin.education.course03.topic04.hw.v3school.model.FacultyV3;
import ga.repin.education.course03.topic04.hw.v3school.model.StudentV3;
import ga.repin.education.course03.topic04.hw.v3school.service.StudentServiceV3;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course03.topic04.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/student")
@Tag(name = "\uD83D\uDC7B️ StudentV3 store", description = "StudentV3 model CRUD endpoints")
public class StudentControllerV3 {
    private final StudentServiceV3 studentService;
    
    public StudentControllerV3(StudentServiceV3 studentService) {
        this.studentService = studentService;
    }
    
    
    @PostMapping
    public ResponseEntity<StudentV3> createStudent(@RequestBody StudentV3 student) {
        StudentV3 result = studentService.create(student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<StudentV3> readStudentByID(@PathVariable Long id) {
        StudentV3 result = studentService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/faculty")
    public ResponseEntity<FacultyV3> facultyByStudent(@PathVariable Long id){
        FacultyV3 result = studentService.facultyOfStudentBy(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping ("/search")
    public ResponseEntity<List<StudentV3>> readStudentsOptionalFilters(
            @RequestParam(value = "age", required = false) Integer specificAge,
            @RequestParam(value = "min-age", required = false) Integer minAge,
            @RequestParam(value = "max-age", required = false) Integer maxAge) {
        
        List<StudentV3> result = new ArrayList<>(studentService.filter(specificAge, minAge, maxAge));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentV3> updateStudent(@PathVariable long id, @RequestBody StudentV3 student) {
        StudentV3 result = studentService.update(id, student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentV3> deleteStudent(@PathVariable long id) {
        StudentV3 result = studentService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
