package org.example.springdemo2.mapper;

import org.example.springdemo2.entity.StudentEntity;
import org.example.springdemo2.entity.TeacherEntity;
import org.example.springdemo2.model.Student;
import org.example.springdemo2.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(target = "teachers", ignore = true)
    Student studentEntityToStudent(StudentEntity entity);

    Teacher toDto(TeacherEntity entity);

    List<Student> toStudentDtoList(List<StudentEntity> studentEntities);

    TeacherEntity toEntity(Teacher teacherDto);
}
