package org.example.springdemo2.mapper;

import org.example.springdemo2.entity.StudentEntity;
import org.example.springdemo2.entity.TeacherEntity;
import org.example.springdemo2.model.Student;
import org.example.springdemo2.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toDto(StudentEntity entity);

    List<Teacher> toTeacherDtoList(List<TeacherEntity> teacherEntities);


    @Mapping(target = "students", ignore = true)
    Teacher teacherEntityToTeacher(TeacherEntity teacherEntity);

    StudentEntity toEntity(Student studentDto);

    void updateEntityFromDto(Student studentDto, @MappingTarget StudentEntity studentEntity);
}
