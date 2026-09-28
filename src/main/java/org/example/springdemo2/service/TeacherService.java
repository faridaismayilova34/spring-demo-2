package org.example.springdemo2.service;

import org.example.springdemo2.mapper.TeacherMapper;
import org.example.springdemo2.model.Teacher;
import org.example.springdemo2.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Transactional(readOnly = true)
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toDto);
    }
}












//@Service
//public class TeacherService {
//
//    private final TeacherRepository teacherRepository;
//
//    public TeacherService(TeacherRepository teacherRepository) {
//        this.teacherRepository = teacherRepository;
//    }
//
//    // ID
//    public Optional<Teacher> getTeacherById(Long id) {
//        Optional<TeacherEntity> teacherEntityOpt = teacherRepository.findById(id);
//
//        if (teacherEntityOpt.isPresent()) {
//            TeacherEntity entity = teacherEntityOpt.get();
//
//            List<Student> studentList = new ArrayList<>();
//            if (entity.getStudents() != null) {
//                entity.getStudents().forEach(s -> {
//                    Student student = new Student(s.getId(), s.getName(), s.getScore(), s.getEmail(), Collections.emptyList());
//                    studentList.add(student);
//                });
//            }
//
//            Teacher teacher = new Teacher(
//                    entity.getId(),
//                    entity.getName(),
//                    entity.getSubject(),
//                    entity.getAge(),
//                    studentList
//            );
//
//            return Optional.of(teacher);
//        }
//
//        return Optional.empty();
//    }
//}