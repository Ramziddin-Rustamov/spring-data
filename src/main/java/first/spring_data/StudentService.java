package first.spring_data;

import first.spring_data.StudentEntity;
import first.spring_data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity create(StudentEntity student){
        studentRepository.save(student);
        return student;
    }
}
