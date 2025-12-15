package pe.edu.vallegrande.rhackatonmariasulca12.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.rhackatonmariasulca12.model.Student;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {
}
