package acc.br.student.mapper;

import acc.br.student.controller.request.StudentRequest;
import acc.br.student.controller.response.StudentResponse;
import acc.br.student.domain.Student;


public class StudentMapper {

    public static Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());
        return student;
    }

    public static StudentResponse toResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }
}