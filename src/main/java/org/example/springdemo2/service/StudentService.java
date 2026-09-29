package org.example.springdemo2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Optional<Student> getStudentById(Long id) {
        log.info("getStudentById start - id: {}", id);
        try {
            Optional<Student> student = studentRepository.findById(id)
                    .map(studentMapper::toDto);

            if (student.isEmpty()) {
                log.warn("getStudentById - Student not found with id: {}", id);
            }

            log.info("getStudentById end - id: {}", id);
            return student;
        } catch (Exception e) {
            log.error("getStudentById error - id: {}, message: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public Student updateStudent(Long id, Student studentRequest) {
        log.info("updateStudent start - id: {}", id);
        try {
            Student updatedStudent = studentRepository.findById(id)
                    .map(existingEntity -> {
                        studentMapper.updateEntityFromDto(studentRequest, existingEntity);
                        var savedEntity = studentRepository.save(existingEntity);
                        return studentMapper.toDto(savedEntity);
                    })
                    .orElseThrow(() -> {
                        log.error("updateStudent error - Student not found with id: {}", id);
                        return new RuntimeException("Student not found with id: " + id);
                    });

            log.info("updateStudent end - id: {}", id);
            return updatedStudent;
        } catch (Exception e) {
            log.error("updateStudent error - Exception occurred: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void deleteStudent(Long id) {
        log.info("deleteStudent start - id: {}", id);
        try {
            studentRepository.deleteById(id);
            log.info("deleteStudent end - id: {}", id);
        } catch (Exception e) {
            log.error("deleteStudent error - id: {}, message: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}

