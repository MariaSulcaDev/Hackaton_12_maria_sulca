package pe.edu.vallegrande.rhackatonmariasulca12.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.rhackatonmariasulca12.model.Student;
import pe.edu.vallegrande.rhackatonmariasulca12.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/api/student")
@RequiredArgsConstructor
@Slf4j
public class StudentRest {

    private final StudentService studentService;

    @GetMapping
    public Flux<Student> findAll(){
        log.info("listando usuarios");
        return studentService.findAll();
    }

    @PostMapping
    public Mono<Student> create(@RequestBody Student student){
        log.info("creando usuario");
        student.setDate(LocalDateTime.now());
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Long id){
        log.info("buscando usuario");
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Student> update(@PathVariable Long id, @RequestBody Student student){
        log.info("actualizando usuario");
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        log.info("eliminando usuario");
        return studentService.delete(id);
    }

}
