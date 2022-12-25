package ga.repin.education.course04.topic01.hw.v6school.controller;

import ga.repin.education.course04.topic01.hw.v6school.entity.FacultyV6;
import ga.repin.education.course04.topic01.hw.v6school.entity.StudentV6;
import ga.repin.education.course04.topic01.hw.v6school.service.StudentServiceV6;
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
public class StudentControllerV6 {
    private final StudentServiceV6 studentService;
    
    public StudentControllerV6(StudentServiceV6 studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping
    public ResponseEntity<StudentV6> createStudent(@RequestBody StudentV6 student) {
        StudentV6 result = studentService.create(student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<StudentV6> readStudentByID(@PathVariable Long id) {
        StudentV6 result = studentService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/faculty")
    public ResponseEntity<FacultyV6> facultyByStudent(@PathVariable Long id){
        FacultyV6 result = studentService.facultyOfStudentBy(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping ("/search")
    public ResponseEntity<List<StudentV6>> readStudentsOptionalFilters(
            @RequestParam(value = "age", required = false) Integer specificAge,
            @RequestParam(value = "min-age", required = false) Integer minAge,
            @RequestParam(value = "max-age", required = false) Integer maxAge) {
        
        List<StudentV6> result = new ArrayList<>(studentService.filter(specificAge, minAge, maxAge));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentV6> updateStudent(@PathVariable long id, @RequestBody StudentV6 student) {
        StudentV6 result = studentService.update(id, student);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentV6> deleteStudent(@PathVariable long id) {
        StudentV6 result = studentService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/total")
    public ResponseEntity<Integer> calculateTotal(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.calculateTotal());
    }
    
    @GetMapping("/average-age")
    public Double calculateAvgAge(){
        return studentService.calculateAvgAge();
    }
    
    
    @GetMapping ("/list-tail")
    public ResponseEntity<List<StudentV6>> listTail(
            @RequestParam(value = "n", required = false,defaultValue = "5") Integer n) {
        List<StudentV6> result = new ArrayList<>(studentService.listTail(n));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
