package net.javaguides.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.javaguides.student.Entity.Student;
import net.javaguides.student.JpaRepository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
	private StudentRepository repository;
	
	public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
