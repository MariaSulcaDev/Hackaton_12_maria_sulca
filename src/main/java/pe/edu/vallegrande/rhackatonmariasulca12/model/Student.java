package pe.edu.vallegrande.rhackatonmariasulca12.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String promotion;
    private LocalDateTime date;
}
