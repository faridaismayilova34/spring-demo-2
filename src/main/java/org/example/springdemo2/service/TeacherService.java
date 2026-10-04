package org.example.springdemo2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springdemo2.entity.TeacherEntity;
import org.example.springdemo2.exception.TeacherNotFoundException;
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
    public Teacher getTeacherById(Long id) {
        log.info("getTeacherWithStudents started with id: {}", id);

        TeacherEntity teacherEntity = teacherRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Teacher not found with this id: {}", id);
                    return new TeacherNotFoundException("Teacher not found with this id: " + id);
                });

        log.info("getTeacherWithStudents method finished successfully with id: {}", id);
        return teacherMapper.toDto(teacherEntity);
    }
}
