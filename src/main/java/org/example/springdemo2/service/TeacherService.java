package org.example.springdemo2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springdemo2.mapper.TeacherMapper;
import org.example.springdemo2.model.Teacher;
import org.example.springdemo2.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Transactional(readOnly = true)
    public Optional<Teacher> getTeacherById(Long id) {
        log.info("getTeacherById start - id: {}", id);

        try {
            Optional<Teacher> teacher = teacherRepository.findById(id)
                    .map(teacherMapper::toDto);

            if (teacher.isEmpty()) {
                log.warn("getTeacherById - Teacher not found with id: {}", id);
            }

            log.info("getTeacherById end - id: {}", id);
            return teacher;
        } catch (Exception e) {
            log.error("getTeacherById error - id: {}, message: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}
