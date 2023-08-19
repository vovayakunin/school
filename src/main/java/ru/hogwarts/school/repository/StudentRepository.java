package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAge(Integer age);

    List<Student> findAllByAgeBetween(int min, int max);

    List<Student> findAllByFaculty_Id(Long facultyId);

}
