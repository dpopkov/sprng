package learn.spr.sh4b.springrestdemo.rest;

import learn.spr.sh4b.springrestdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (studentId < 0 || studentId >= studentsList.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentsList.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
