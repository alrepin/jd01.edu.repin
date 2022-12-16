package ga.repin.education.course03.topic06.hw.v5school.controller;

import ga.repin.education.course03.topic06.hw.v5school.model.FacultyV5;
import ga.repin.education.course03.topic06.hw.v5school.model.StudentV5;
import ga.repin.education.course03.topic06.hw.v5school.service.FacultyServiceV5;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ga.repin.education.course03.topic06.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/faculty")
@Tag(name = "\uD83C\uDF93 Faculty store", description = "Faculty model CRUD endpoints")
public class FacultyControllerV5 {
    private final FacultyServiceV5 facultyService;
    
    public FacultyControllerV5(FacultyServiceV5 facultyService) {
        this.facultyService = facultyService;
    }
    
    
    @PostMapping()
    public ResponseEntity<FacultyV5> createFaculty(@RequestBody FacultyV5 faculty) {
        FacultyV5 result = facultyService.create(faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FacultyV5> readFacultyByID(@PathVariable long id) {
        FacultyV5 result = facultyService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/students")
    public ResponseEntity<Collection<StudentV5>> studentsByFaculty(@PathVariable long id) {
        return ResponseEntity.ok(facultyService.studentsByFaculty(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<FacultyV5>> readFacultiesOptionalSearch(
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "query",  required = false) String query) {
        List<FacultyV5> result = new ArrayList<>(facultyService.filter(query,color));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FacultyV5> updateFaculty(@PathVariable long id, @RequestBody FacultyV5 faculty) {
        FacultyV5 result = facultyService.update(id, faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyV5> deleteFaculty(@PathVariable long id) {
        FacultyV5 result = facultyService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
