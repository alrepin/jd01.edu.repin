package ga.repin.education.course02.topic12.lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    Map<Integer, Student> allStudents = new HashMap<Integer, Student>();
    private int countId = 1;

    public void addStudent(Student student) {
        if (allStudents == null) {
            allStudents = new HashMap<Integer, Student>();
        }
        student.setId(countId);
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
