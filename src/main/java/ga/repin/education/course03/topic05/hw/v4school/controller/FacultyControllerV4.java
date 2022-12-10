package ga.repin.education.course03.topic05.hw.v4school.controller;

import ga.repin.education.course03.topic05.hw.v4school.model.FacultyV4;
import ga.repin.education.course03.topic05.hw.v4school.model.StudentV4;
import ga.repin.education.course03.topic05.hw.v4school.service.FacultyServiceV4;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ga.repin.education.course03.topic05.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/faculty")
@Tag(name = "\uD83C\uDF93 Faculty store", description = "Faculty model CRUD endpoints")
public class FacultyControllerV4 {
    private final FacultyServiceV4 facultyService;
    
    public FacultyControllerV4(FacultyServiceV4 facultyService) {
        this.facultyService = facultyService;
    }
    
    
    @PostMapping()
    public ResponseEntity<FacultyV4> createFaculty(@RequestBody FacultyV4 faculty) {
        FacultyV4 result = facultyService.create(faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FacultyV4> readFacultyByID(@PathVariable long id) {
        FacultyV4 result = facultyService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/students")
    public ResponseEntity<Collection<StudentV4>> studentsByFaculty(@PathVariable long id) {
        return ResponseEntity.ok(facultyService.studentsByFaculty(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<FacultyV4>> readFacultiesOptionalSearch(
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "query",  required = false) String query) {
        List<FacultyV4> result = new ArrayList<>(facultyService.filter(query,color));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FacultyV4> updateFaculty(@PathVariable long id, @RequestBody FacultyV4 faculty) {
        FacultyV4 result = facultyService.update(id, faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyV4> deleteFaculty(@PathVariable long id) {
        FacultyV4 result = facultyService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
