package net.javaguides.student.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.student.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findAllBySchoolId(Integer schoolId);
}
