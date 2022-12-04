package ga.repin.education.course03.topic02.hw.v1school.controller;

import ga.repin.education.course03.topic02.hw.v1school.model.FacultyV1;
import ga.repin.education.course03.topic02.hw.v1school.service.FacultyServiceV1;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course03.topic02.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/faculty")
@Tag(name = "\uD83C\uDF93 FacultyV1 store", description = "FacultyV1 model CRUD endpoints")
public class FacultyControllerV1 {
    private final FacultyServiceV1 facultyServiceV1;
    
    public FacultyControllerV1(FacultyServiceV1 facultyServiceV1) {
        this.facultyServiceV1 = facultyServiceV1;
    }
    
    
    @PostMapping()
    public ResponseEntity<FacultyV1> createFaculty(@RequestBody FacultyV1 faculty) {
        FacultyV1 result = facultyServiceV1.create(faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FacultyV1> readFacultyByID(@PathVariable long id) {
        FacultyV1 result = facultyServiceV1.get(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping
    public ResponseEntity<List<FacultyV1>> readFacultiesOptionalColorFilter(@RequestParam(value = "color", required = false) String color) {
        List<FacultyV1> result = new ArrayList<>(facultyServiceV1.getFaculties(color));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FacultyV1> updateFaculty(@PathVariable long id, @RequestBody FacultyV1 faculty) {
        FacultyV1 result = facultyServiceV1.update(id, faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyV1> deleteFaculty(@PathVariable long id) {
        FacultyV1 result = facultyServiceV1.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
