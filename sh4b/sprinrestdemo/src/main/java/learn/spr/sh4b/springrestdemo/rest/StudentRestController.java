package learn.spr.sh4b.springrestdemo.rest;

import learn.spr.sh4b.springrestdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> students() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Bobby", "Doe"));
        list.add(new Student("Alice", "Miller"));
        list.add(new Student("Jane", "Draper"));
        return list;
    }
}
