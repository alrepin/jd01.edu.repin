package ga.repin.education.course04.topic01.hw.v6school.controller;

import ga.repin.education.course04.topic01.hw.v6school.entity.Faculty;
import ga.repin.education.course04.topic01.hw.v6school.entity.Student;
import ga.repin.education.course04.topic01.hw.v6school.repository.AvatarRepository;
import ga.repin.education.course04.topic01.hw.v6school.repository.FacultyRepository;
import ga.repin.education.course04.topic01.hw.v6school.repository.StudentRepository;
import ga.repin.education.course04.topic01.hw.v6school.service.AvatarService;
import ga.repin.education.course04.topic01.hw.v6school.service.FacultyService;
import ga.repin.education.course04.topic01.hw.v6school.service.StudentService;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FacultyController.class)
class FacultyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @SpyBean
    private FacultyService facultyService;
    @SpyBean
    private AvatarService avatarService;
    @SpyBean
    private StudentService studentService;
    
    @MockBean
    private FacultyRepository facultyRepository;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private AvatarRepository avatarRepository;
    
    @InjectMocks
    private FacultyController facultyController;
    
    final private List<Faculty> FACULTY_LIST = List.of(
            new Faculty(1L, "fac1", "red"),
            new Faculty(2L, "fac2", "green"),
            new Faculty(3L, "fac3", "green"),
            new Faculty(4L, "fAc3", "grEen"));
    List<Student> STUDENT_LIST = List.of(
            new Student(1L, "stud1", 11),
            new Student(2L, "stud2", 12),
            new Student(3L, "stud3", 13)
    );
    final String COLOR_GREEN = "green";
    final String NAME_IGNORE_CASE = "FAc3";
    final String COLOR_IGNORE_CASE = "GrEeN";
    
    final int ZERO = 0;
    final int ONE = 1;
    final int TWO = 2;
    final int THREE = 3;
    final int FOUR = 4;
    
    @Test
    void search_faculty_endpoint_test() throws Exception {
        when(facultyRepository.findAll()).thenReturn(FACULTY_LIST);
        when(facultyRepository.findByColor(anyString())).thenReturn(FACULTY_LIST
                .stream().filter(f -> f.getColor().equals(COLOR_GREEN)).collect(Collectors.toList()));
        when(facultyRepository.findByNameIgnoreCaseAndColor(NAME_IGNORE_CASE, COLOR_GREEN)).thenReturn(
                FACULTY_LIST.stream().filter(f -> f.getName().equalsIgnoreCase(NAME_IGNORE_CASE) && f.getColor().equals(COLOR_GREEN))
                        .collect(Collectors.toList()));
        when(facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(COLOR_IGNORE_CASE, COLOR_IGNORE_CASE)).thenReturn(
                FACULTY_LIST.stream().filter(f -> f.getColor().equalsIgnoreCase(COLOR_IGNORE_CASE))
                        .collect(Collectors.toList()));
        
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/search"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.isA(Collection.class)))
                .andExpect(jsonPath("$.*", Matchers.hasSize(FOUR)))
        ;
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/search?color=" + COLOR_GREEN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.isA(Collection.class)))
                .andExpect(jsonPath("$.*", hasSize(TWO)))
                .andExpect(jsonPath("$[0].id").value(FACULTY_LIST.get(ONE).getId()))
                .andExpect(jsonPath("$[1].id").value(FACULTY_LIST.get(TWO).getId()))
                .andExpect(jsonPath("$[0].name").value(FACULTY_LIST.get(ONE).getName()))
                .andExpect(jsonPath("$[0].color").value(FACULTY_LIST.get(ONE).getColor()))
        ;
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/search?color=" + COLOR_GREEN + "&query=" + NAME_IGNORE_CASE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.isA(Collection.class)))
                .andExpect(jsonPath("$.*", hasSize(ONE)))
                .andExpect(jsonPath("$[0].id").value(FACULTY_LIST.get(TWO).getId()))
                .andExpect(jsonPath("$[0].name").value(FACULTY_LIST.get(TWO).getName()))
                .andExpect(jsonPath("$[0].color").value(FACULTY_LIST.get(TWO).getColor()))
        ;
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/search?query=" + COLOR_IGNORE_CASE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.isA(Collection.class)))
                .andExpect(jsonPath("$.*", hasSize(THREE)))
                .andExpect(jsonPath("$[0].id").value(FACULTY_LIST.get(ONE).getId()))
                .andExpect(jsonPath("$[0].name").value(FACULTY_LIST.get(ONE).getName()))
                .andExpect(jsonPath("$[0].color").value(FACULTY_LIST.get(ONE).getColor()))
        ;
    }
    
    @Test
    void read_faculty_by_ID_endpoint_test() throws Exception {
        Faculty expected = FACULTY_LIST.get(ZERO);
        when(facultyRepository.findById(anyLong())).thenReturn(Optional.of(expected));
        
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/" + ONE)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.name").value(expected.getName()))
                .andExpect(jsonPath("$.color").value(expected.getColor()));
    }
    
    @Test
    void students_by_faculty_endpoint_test() throws Exception {
        final long FIRST_FACULTY_ID = 1L;
        final Faculty FIRST_FACULTY = FACULTY_LIST.get(ZERO);
        FIRST_FACULTY.setStudents(STUDENT_LIST);
        when(facultyRepository.findById(anyLong())).thenReturn(Optional.of(FIRST_FACULTY));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/" + FIRST_FACULTY_ID + "/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.isA(Collection.class)))
                .andExpect(jsonPath("$.*", hasSize(3)));
    }
    
    @Test
    void create_faculty_endpoint_test() throws Exception {
        final Faculty SECOND_FACULTY = FACULTY_LIST.get(ONE);
        JSONObject facultyJSON = new JSONObject();
        facultyJSON.put("id", SECOND_FACULTY.getId());
        facultyJSON.put("name", SECOND_FACULTY.getName());
        facultyJSON.put("color", SECOND_FACULTY.getColor());
        
        when(facultyRepository.save(any(Faculty.class))).thenReturn(SECOND_FACULTY);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty")
                        .content(facultyJSON.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(SECOND_FACULTY.getId()))
                .andExpect(jsonPath("$.name").value(SECOND_FACULTY.getName()))
                .andExpect(jsonPath("$.color").value(SECOND_FACULTY.getColor()));
    }
    
    @Test
    void update_faculty_endpoint_test() throws Exception {
        final Faculty THIRD_FACULTY = FACULTY_LIST.get(TWO);
        JSONObject facultyJSON = new JSONObject();
        facultyJSON.put("id", THIRD_FACULTY.getId());
        facultyJSON.put("name", THIRD_FACULTY.getName());
        facultyJSON.put("color", THIRD_FACULTY.getColor());
        when(facultyRepository.existsById(anyLong())).thenReturn(true);
        when(facultyRepository.save(any(Faculty.class))).thenReturn(THIRD_FACULTY);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/" + THREE)
                        .content(facultyJSON.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(THIRD_FACULTY.getId()))
                .andExpect(jsonPath("$.name").value(THIRD_FACULTY.getName()))
                .andExpect(jsonPath("$.color").value(THIRD_FACULTY.getColor()))
        ;
    }
    
    @Test
    void delete_faculty_endpoint_test() throws Exception {
        final Faculty THIRD_FACULTY = FACULTY_LIST.get(TWO);
        when(facultyRepository.findById(anyLong())).thenReturn(Optional.of(THIRD_FACULTY));
        doNothing().when(facultyRepository).deleteAll(anyList());
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/" + ga.repin.education.course04.topic01.hw.HwConstants.HW_ENDPOINT + "/faculty/" + THREE))
                .andExpect(status().isOk());
        verify(facultyRepository, atLeast(1)).deleteAll(anyList());
    }
}