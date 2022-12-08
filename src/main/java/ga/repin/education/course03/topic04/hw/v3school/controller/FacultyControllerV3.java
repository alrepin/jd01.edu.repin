package ga.repin.education.course03.topic04.hw.v3school.controller;

import ga.repin.education.course03.topic04.hw.v3school.model.FacultyV3;
import ga.repin.education.course03.topic04.hw.v3school.model.StudentV3;
import ga.repin.education.course03.topic04.hw.v3school.service.FacultyServiceV3;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ga.repin.education.course03.topic04.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/faculty")
@Tag(name = "\uD83C\uDF93 FacultyV3 store", description = "FacultyV3 model CRUD endpoints")
public class FacultyControllerV3 {
    private final FacultyServiceV3 facultyService;
    
    public FacultyControllerV3(FacultyServiceV3 facultyService) {
        this.facultyService = facultyService;
    }
    
    
    @PostMapping()
    public ResponseEntity<FacultyV3> createFaculty(@RequestBody FacultyV3 faculty) {
        FacultyV3 result = facultyService.create(faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FacultyV3> readFacultyByID(@PathVariable long id) {
        FacultyV3 result = facultyService.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}/students")
    public ResponseEntity<Collection<StudentV3>> studentsByFaculty(@PathVariable long id) {
        return ResponseEntity.ok(facultyService.studentsByFaculty(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<FacultyV3>> readFacultiesOptionalSearch(
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "query",  required = false) String query) {
        List<FacultyV3> result = new ArrayList<>(facultyService.filter(query,color));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FacultyV3> updateFaculty(@PathVariable long id, @RequestBody FacultyV3 faculty) {
        FacultyV3 result = facultyService.update(id, faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyV3> deleteFaculty(@PathVariable long id) {
        FacultyV3 result = facultyService.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
