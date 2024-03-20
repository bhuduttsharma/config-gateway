package net.javaguides.school.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.javaguides.school.Entity.School;
import net.javaguides.school.dto.FullSchoolResponse;
import net.javaguides.school.service.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

	@Autowired
	private SchoolService service;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody School student
    ) {
        service.saveSchool(student);
    }
	
	@GetMapping
    public ResponseEntity<List<School>> findAllStudents() {
        return ResponseEntity.ok(service.findAllSchools());
    }

	@GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
    }

}
