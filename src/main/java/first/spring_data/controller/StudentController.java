package first.spring_data.controller;

import first.spring_data.dto.StudentDTO;
import first.spring_data.model.StudentEntity;
import first.spring_data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        StudentDTO result = studentService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    private ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<StudentDTO> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(studentService.getById(id));
    }
}
