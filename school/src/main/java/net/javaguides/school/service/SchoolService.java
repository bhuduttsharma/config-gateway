package net.javaguides.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.javaguides.school.Entity.School;
import net.javaguides.school.JpaRepository.SchoolRepository;
import net.javaguides.school.client.StudentClient;
import net.javaguides.school.dto.FullSchoolResponse;
import net.javaguides.student.Entity.Student;
import net.javaguides.student.JpaRepository.StudentRepository;

@Service
@RequiredArgsConstructor
public class SchoolService {
	
	@Autowired
	private SchoolRepository repository;
	@Autowired
	private StudentClient client;
	
	public void saveSchool(School school) {
        repository.save(school);
    }
	 public List<School> findAllSchools() {
	        return repository.findAll();
	    }
	 
	 public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
		 
	        var school = repository.findById(schoolId)
	                .orElse(
	                        School.builder()
	                                .name("NOT_FOUND")
	                                .email("NOT_FOUND")
	                                .build()
	                );
	        var students = client.findAllStudentsBySchool(schoolId);
	        return FullSchoolResponse.builder()
	                .name(school.getName())
	                .email(school.getEmail())
	                .students(students)
	                .build();
	    }
}
