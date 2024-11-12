package com.Student_app_using_fileSystem.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentService {

	private static final String DIRECTORY = "student-details";

    public StudentService() {
        File directory = new File(DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private File getEmployeeFile(Integer id) {
        return new File(DIRECTORY + "/" + id + ".json");
    }

    public List<Students> findAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Students> student = new ArrayList<>();
        File folder = new File(DIRECTORY);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
        	student.add(mapper.readValue(file, Students.class));
        }
        return student;
    }

    public Optional<Students> findById(Integer id) throws IOException {
        File file = getEmployeeFile(id);
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            return Optional.of(mapper.readValue(file, Students.class));
        }
        return Optional.empty();
    }

    public Students save(Students student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = getEmployeeFile(student.getStudentId());
        mapper.writeValue(file, student);
        return student;
    }

    public void deleteById(Integer id) {
        File file = getEmployeeFile(id);
        if (file.exists()) {
            file.delete();
        }
    }
}
