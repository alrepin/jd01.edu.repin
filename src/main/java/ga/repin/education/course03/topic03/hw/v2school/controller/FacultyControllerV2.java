package ga.repin.education.course03.topic03.hw.v2school.controller;

import ga.repin.education.course03.topic03.hw.v2school.model.FacultyV2;
import ga.repin.education.course03.topic03.hw.v2school.service.FacultyServiceV2;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static ga.repin.education.course03.topic03.hw.HwConstants.HW_ENDPOINT;

@RestController
@RequestMapping(HW_ENDPOINT + "/faculty")
@Tag(name = "\uD83C\uDF93 FacultyV2 store", description = "FacultyV2 model CRUD endpoints")
public class FacultyControllerV2 {
    private final FacultyServiceV2 facultyServiceV2;
    
    public FacultyControllerV2(FacultyServiceV2 facultyServiceV2) {
        this.facultyServiceV2 = facultyServiceV2;
    }
    
    
    @PostMapping()
    public ResponseEntity<FacultyV2> createFaculty(@RequestBody FacultyV2 faculty) {
        FacultyV2 result = facultyServiceV2.create(faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FacultyV2> readFacultyByID(@PathVariable long id) {
        FacultyV2 result = facultyServiceV2.read(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @GetMapping
    public ResponseEntity<List<FacultyV2>> readFacultiesOptionalColorFilter(@RequestParam(value = "color", required = false) String color) {
        List<FacultyV2> result = new ArrayList<>(facultyServiceV2.filter(color));
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FacultyV2> updateFaculty(@PathVariable long id, @RequestBody FacultyV2 faculty) {
        FacultyV2 result = facultyServiceV2.update(id, faculty);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyV2> deleteFaculty(@PathVariable long id) {
        FacultyV2 result = facultyServiceV2.delete(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
