package acc.br.student.service;

import acc.br.student.controller.request.StudentRequest;
import acc.br.student.controller.response.StudentResponse;

import acc.br.student.mapper.StudentMapper;
import acc.br.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentResponse> getAll() {
        return repository.findAll().stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse getById(Long id) {
        return repository.findById(id)
                .map(StudentMapper::toResponse)
                .orElse(null);
    }

    public void create(StudentRequest request) {
        repository.save(StudentMapper.toEntity(request));
    }

    public void update(Long id, StudentRequest request) {
        repository.findById(id).ifPresent(student -> {
            student.setName(request.getName());
            student.setAge(request.getAge());
            student.setEmail(request.getEmail());
            repository.save(student);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}