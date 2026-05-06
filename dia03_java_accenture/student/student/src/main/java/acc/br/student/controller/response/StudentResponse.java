package acc.br.student.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private int age;
    private String email;
}