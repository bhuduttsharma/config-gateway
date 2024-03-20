package net.javaguides.school.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.school.Entity.School;
import net.javaguides.student.Entity.Student;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
	private String name;
    private String email;
    List<Student> students;
}
