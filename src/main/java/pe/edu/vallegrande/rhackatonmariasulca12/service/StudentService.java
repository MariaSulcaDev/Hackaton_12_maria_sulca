package pe.edu.vallegrande.rhackatonmariasulca12.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.vallegrande.rhackatonmariasulca12.model.Student;
import pe.edu.vallegrande.rhackatonmariasulca12.repository.StudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;
    public Flux<Student> findAll(){
        return studentRepository.findAll();
    }

    public Mono<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public Mono<Student> save(Student student){
        return studentRepository.save(student);
    }

    public Mono<Student> update(Long id, Student student) {
        return studentRepository.findById(id)
                .flatMap(existingStudent -> {
                    existingStudent.setDni(student.getDni());
                    existingStudent.setFirstName(student.getFirstName());
                    existingStudent.setLastName(student.getLastName());
                    existingStudent.setPromotion(student.getPromotion());
                    existingStudent.setDate(LocalDateTime.now());
                    return studentRepository.save(existingStudent);
                });
    }

    public Mono<Void> delete(Long id){
        return studentRepository.deleteById(id);
    }
}
