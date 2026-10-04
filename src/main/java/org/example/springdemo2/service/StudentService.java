package org.example.springdemo2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springdemo2.entity.StudentEntity;
import org.example.springdemo2.exception.StudentNotFoundException;
import org.example.springdemo2.mapper.StudentMapper;
import org.example.springdemo2.model.Student;
import org.example.springdemo2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        log.info("getStudentById started with id: {}", id);

        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Student not found with id: {}", id);
                    return new StudentNotFoundException("Student not found with id: " + id);
                });

        log.info("getStudentById method finished successfully for id: {}", id);
        return studentMapper.toDto(studentEntity);
    }

    public Student updateStudent(Long id, Student studentRequest) {
        log.info("updateStudent method started with id: {}, Student: {}", id, studentRequest);

        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Student not found with this id: {}", id);
                    return new StudentNotFoundException("Student not found with this id: " + id);
                });

        studentMapper.updateEntityFromDto(studentRequest, studentEntity);
        StudentEntity savedEntity = studentRepository.save(studentEntity);

        log.info("updateStudent method finished successfully for id: {}, Student: {}", id, studentRequest);
        return studentMapper.toDto(savedEntity);
    }

    public void deleteStudent(Long id) {
        log.info("removeStudent method started with id: {}", id);

        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Student not found with this id: {}", id);
                    return new StudentNotFoundException("Student not found with this id: " + id);
                });

        studentRepository.delete(studentEntity);
        log.info("removeStudent method finished successfully with id: {}", id);
    }
}
