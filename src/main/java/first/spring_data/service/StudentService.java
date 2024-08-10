package first.spring_data.service;

import first.spring_data.dto.StudentDTO;
import first.spring_data.model.StudentEntity;
import first.spring_data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO create(StudentDTO dto){
       StudentEntity student = new StudentEntity();
       student.setName(dto.getName());
       student.setSurname(dto.getSurname());
       student.setAge(dto.getAge());

       studentRepository.save(student);
       dto.setId(student.getId());
       return dto;
    }

    public List<StudentDTO> getAll(){
      Iterable<StudentEntity> students =  studentRepository.findAll();
      List<StudentDTO> list = new LinkedList<>();
      for(StudentEntity stu : students){

          list.add(toDTO(stu));
      }
      return  list;
    }

    public StudentDTO getById(Integer id){
       Optional<StudentEntity> student =  studentRepository.findById(id);
       if(student.isEmpty()){
           return null;
       }
       StudentEntity entity = student.get();
       return toDTO(entity);
    }

    public List<StudentDTO> findByName(String name){
        List<StudentEntity> students = studentRepository.findByName(name);
        List<StudentDTO> list = new LinkedList<>();
        for(StudentEntity data : students){
            list.add(toDTO(data));
        }
        return list;
    }

    public StudentDTO update(Integer id , StudentDTO data){
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }

        StudentEntity student = optional.get();
        student.setName(data.getName());
        student.setSurname(data.getSurname());
        student.setAge(data.getAge());
        studentRepository.save(student);

        data.setId(student.getId());
        return data;
    }


    public void delete(Integer id){
       studentRepository.deleteById(id);
    }

    public StudentDTO toDTO(StudentEntity entity){
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        return dto;
    }
}
