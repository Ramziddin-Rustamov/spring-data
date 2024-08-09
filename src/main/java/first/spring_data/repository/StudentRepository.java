package first.spring_data.repository;

import first.spring_data.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {

}
