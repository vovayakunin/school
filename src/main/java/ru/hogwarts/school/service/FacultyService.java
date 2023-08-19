package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;


@Service
public class FacultyService {


    private final FacultyRepository facultyRepository;
    private Faculty exsitingFaculty;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getById(Long id) {
        return facultyRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    public Faculty update(Long id, Faculty faculty) {
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
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Collection<Faculty> getALl() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }
}

