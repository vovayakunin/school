package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    public Collection<Student> getALl() {
        return studentRepository.findAll();
    }


    public Collection<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);
    }


    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Long id, Student student) {

        Student exsitingStudent = studentRepository.findById(id).orElseThrow(DataNotFoundException::new);
        Optional.ofNullable(student.getName()).ifPresent(exsitingStudent::setName);
        Optional.ofNullable(student.getAge()).ifPresent(exsitingStudent::setAge);
        return studentRepository.save(exsitingStudent);
    }

    public Student delete(Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(DataNotFoundException::new);
        studentRepository.delete(existingStudent);
        return existingStudent;
    }

    public Collection<Student> getByAgeBetween(int min, int max) {
        return studentRepository.findAllByAgeBetween(min, max);
    }

    public Collection<Student> getByFacultyId(Long facultyId) {
        return studentRepository.findAllByFaculty_Id(facultyId);
    }

    public long count() {
        return studentRepository.countStudent();
    }

    public double average() {
        return studentRepository.averageAge();
    }

    public List<Student> getLastStudents(int quantity) {
        return studentRepository.findLastStudents(quantity);
    }
}
