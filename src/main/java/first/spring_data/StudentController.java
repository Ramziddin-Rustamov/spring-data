package first.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentEntity create(@RequestBody StudentEntity student) {
        return studentService.create(student);
    }
}
