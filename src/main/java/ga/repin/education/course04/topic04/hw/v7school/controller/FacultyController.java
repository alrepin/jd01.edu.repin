package ga.repin.education.course04.topic04.hw.v7school.controller;

import ga.repin.education.course04.topic04.hw.v7school.entity.Faculty;
import ga.repin.education.course04.topic04.hw.v7school.entity.Student;
import ga.repin.education.course04.topic04.hw.v7school.service.FacultyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ga.repin.education.course04.topic04.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/faculty")
@Tag(name = "\uD83C\uDF93 Faculty store", description = "Faculty model CRUD endpoints")
public class FacultyController {
    private final FacultyService facultyService;
    
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    
    
    @PostMapping()
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty result = facultyService.create(faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> readFacultyByID(@PathVariable long id) {
        Faculty result = facultyService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/students")
    public ResponseEntity<Collection<Student>> studentsByFaculty(@PathVariable long id) {
        return ResponseEntity.ok(facultyService.studentsByFaculty(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Faculty>> readFacultiesOptionalSearch(
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "query",  required = false) String query) {
        List<Faculty> result = new ArrayList<>(facultyService.filter(query,color));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable long id, @RequestBody Faculty faculty) {
        Faculty result = facultyService.update(id, faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long id) {
        Faculty result = facultyService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
