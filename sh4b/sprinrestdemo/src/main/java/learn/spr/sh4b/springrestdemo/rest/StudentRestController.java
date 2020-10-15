package learn.spr.sh4b.springrestdemo.rest;

import learn.spr.sh4b.springrestdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final ArrayList<Student> studentsList = new ArrayList<>();

    @PostConstruct
    private void loadData() {
        studentsList.add(new Student("Bobby", "Doe"));
        studentsList.add(new Student("Alice", "Miller"));
        studentsList.add(new Student("Jane", "Draper"));
    }

    @GetMapping("/students")
    public List<Student> students() {
        return studentsList;
    }

    @GetMapping("/students/{studentId}")
    public Student student(@PathVariable int studentId) {
        return studentsList.get(studentId);
    }
}
