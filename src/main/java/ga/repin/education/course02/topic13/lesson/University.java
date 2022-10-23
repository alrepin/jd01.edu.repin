package ga.repin.education.course02.topic13.lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    private final StudentValueGenerator studentValueGenerator;
    Map<Integer, Student> allStudents = new HashMap<>();
    private int countId = 1;

    public University(StudentValueGenerator studentValueGenerator) {
        this.studentValueGenerator = studentValueGenerator;
    }


    public void addStudentInRange(Student student, int minYo, int maxYo) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
        studentValueGenerator.generateAge();
        studentValueGenerator.generateAge();
        student.setAge(studentValueGenerator.generateAgeInRange(minYo,maxYo));
        allStudents.put(countId, student);
        countId++;
    }

    public void addStudent(Student student) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
        student.setAge(studentValueGenerator.generateAge());
        student.setAge(studentValueGenerator.generateAge());
        allStudents.put(countId, student);
        countId++;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(allStudents.values());
    }

    public List<Student> getAllStudents(boolean isMale) {
        return allStudents.values().stream()
                .filter(e -> e.isMale()==isMale)
                .collect(Collectors.toList());
    }

}
