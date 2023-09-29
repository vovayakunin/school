package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.Comparator;


@Service
public class FacultyService {
    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);


    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;
    private Faculty exsitingFaculty;

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty create(Faculty faculty) {
        logger.info("invoked method create");
        return facultyRepository.save(faculty);
    }

    public Faculty getById(Long id) {
        logger.info("invoked method getById");
        logger.debug("id = " + id);
        return facultyRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    public Faculty update(Long id, Faculty faculty) {
        logger.info("invoked method update");
        Faculty existingFaculty = facultyRepository
                .findById(id).orElseThrow(DataNotFoundException::new);
        if (faculty.getColor() != null) {
            exsitingFaculty.setColor(faculty.getColor());
        }
        if (faculty.getName() != null) {
            exsitingFaculty.setName(faculty.getName());
        }
        return facultyRepository.save(existingFaculty);
    }

    public Faculty delete(long id) {
        logger.info("invoked method delete");
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Collection<Faculty> getALl() {
        logger.info("invoked method getALl");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getByColor(String color) {
        logger.info("invoked method getByColor");
        return facultyRepository.findAllByColor(color);
    }

    public Collection<Faculty> getByColorOrName(String color, String name) {
        logger.info("invoked method getByColorOrName");
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(color, name);
    }

    public Faculty getByStudentId(Long studentId) {
        logger.info("invoked method getByStudentId");
        return facultyRepository.findByStudent_Id(studentId).orElseThrow(DataNotFoundException::new);
    }

    public String getLongestName() {
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(DataNotFoundException::new);

    }


}

