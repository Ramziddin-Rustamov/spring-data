package first.spring_data.repository;

import first.spring_data.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
   List<StudentEntity> findByName(String name);
}
