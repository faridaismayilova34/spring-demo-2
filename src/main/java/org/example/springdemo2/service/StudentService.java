package org.example.springdemo2.service;

import org.example.springdemo2.entity.StudentEntity;
import org.example.springdemo2.mapper.StudentMapper;
import org.example.springdemo2.model.Student;
import org.example.springdemo2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    //  GET: ID
    @Transactional(readOnly = true)
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto);
    }

   // PUT:Update
    public Student updateStudent(Long id, Student studentRequest) {
        return studentRepository.findById(id)
                .map(existingEntity -> {
                    studentMapper.updateEntityFromDto(studentRequest, existingEntity);

                    StudentEntity savedEntity = studentRepository.save(existingEntity);
                    return studentMapper.toDto(savedEntity);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // DELETE:
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
























//public class StudentService {
//    private final StudentRepository studentRepository;
//
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    // ID
//    public Optional<Student> getStudentById(Long id) {
//        Optional<StudentEntity> studentEntityOpt = studentRepository.findById(id);
//
//        if (studentEntityOpt.isPresent()) {
//            StudentEntity entity = studentEntityOpt.get();
//
//            List<Teacher> teacherList = new ArrayList<>();
//            if (entity.getTeachers() != null) {
//                entity.getTeachers().forEach(t -> {
//                    Teacher teacher = new Teacher(t.getId(), t.getName(), t.getSubject(), t.getAge(), Collections.emptyList());
//                    teacherList.add(teacher);
//                });
//            }
//
//            Student student = new Student(
//                    entity.getId(),
//                    entity.getName(),
//                    entity.getScore(),
//                    entity.getEmail(),
//                    teacherList
//            );
//
//            return Optional.of(student);
//        }
//
//        return Optional.empty();
//    }
//
//    //  (PUT)
//    public Student updateStudent(Long id, Student studentRequest) {
//        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);
//
//        if (optionalStudent.isPresent()) {
//            StudentEntity studentEntity = optionalStudent.get();
//            studentEntity.setName(studentRequest.getName());
//            studentEntity.setScore(studentRequest.getScore());
//            studentEntity.setEmail(studentRequest.getEmail());
//
//            StudentEntity savedEntity = studentRepository.save(studentEntity);
//
//            List<Teacher> teacherList = new ArrayList<>();
//            if (savedEntity.getTeachers() != null) {
//                savedEntity.getTeachers().forEach(t -> {
//                    Teacher teacher = new Teacher(t.getId(), t.getName(), t.getSubject(), t.getAge(), Collections.emptyList());
//                    teacherList.add(teacher);
//                });
//            }
//
//            return new Student(
//                    savedEntity.getId(),
//                    savedEntity.getName(),
//                    savedEntity.getScore(),
//                    savedEntity.getEmail(),
//                    teacherList
//            );
//        } else {
//            throw new RuntimeException("Student not found: " + id);
//        }
//    }
//
//    //  (DELETE)
//    public void deleteStudent(Long id) {
//        studentRepository.deleteById(id);
//    }
//}
//
