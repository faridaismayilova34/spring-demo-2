package org.example.springdemo2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import org.example.springdemo2.entity.TeacherEntity;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "teachers")
@EqualsAndHashCode(exclude = "teachers")
public class Student {
    private Long id;
    private String name;
    private Double score;
    private String email;

    private List<Teacher> teachers;
}