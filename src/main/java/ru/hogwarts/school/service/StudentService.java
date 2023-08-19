package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> map = new HashMap<>();
    private Long COUNTER = 1L;

    public Student getById(Long id) {
        return map.get(id);
    }

    public Collection<Student> getALl() {
        return map.values();
    }


    public Collection<Student> getByAge(int age) {
        return map.values().stream()
                .filter(s -> s.getAge() == age)
                .collect(Collectors.toList());
    }


    public Student create(Student student) {
        Long nextID = COUNTER++;
        student.setId(nextID);
        map.put(student.getId(), student);
        return student;
    }

    public Student update(Long id, Student student) {
        if (!map.containsKey(id)) {
            throw new DataNotFoundException();
        }
        Student exsitingStudent = map.get(id);
        exsitingStudent.setName(student.getName());
        exsitingStudent.setAge(student.getAge());
        return exsitingStudent;
    }

    public void delete(Long id) {
        if (map.remove(id) == null) {
            throw new DataNotFoundException();
        }
    }
}
