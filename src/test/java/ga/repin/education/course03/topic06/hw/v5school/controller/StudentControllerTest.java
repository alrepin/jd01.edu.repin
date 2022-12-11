package ga.repin.education.course03.topic06.hw.v5school.controller;

import ga.repin.education.course03.topic06.hw.v5school.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    
    @LocalServerPort
    private String port;
    
    @Autowired
    private StudentController studentController;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void contextLoads() throws Exception{
        Assertions.assertThat(studentController).isNotNull();
    }
    
    @Test
    void search_student_endpoint_test(){
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                .isNotNull();
        final int age = 11;
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?age" + age, String.class))
                .isNotNull();
        final int minAge = 11;
        final int maxAge = 13;
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student?min=" + minAge + "&max=" + maxAge, String.class))
                .isNotNull();
    }
    
    @Test
    void read_student_by_ID_endpoint_test() throws Exception {
        final long id = 1L;
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/" + id, String.class))
                .isNotNull();
    }
    
    @Test
    void faculty_by_student_endpoint_test(){
        final int studentId = 1;
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/" + studentId + "/faculty", String.class))
                .isNotNull();
    }
    
    @Test
    void create_student_endpoint_test(){
        Student student = new Student();
        student.setAge(20);
        student.setName("stud10");
        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }
    
    @Test
    void update_student_endpoint_test(){
        Student student = new Student();
        student.setAge(20);
        student.setName("stud2");
        student.setId(2L);
        
        RequestEntity<Student> requestEntity = new RequestEntity<>(student, HttpMethod.PUT,
                URI.create("http://localhost:" + port + "/student"));
        
        Assertions.assertThat(this.restTemplate.exchange(requestEntity, String.class)).isNotNull();
    }
    
    @Test
    void delete_student_endpoint_test(){
        final long studentId = 10;
        Assertions.assertThat(this.restTemplate.exchange("http://localhost:" + port + "/student/" + studentId, HttpMethod.DELETE,
                null, String.class)).isNotNull();
    }
}