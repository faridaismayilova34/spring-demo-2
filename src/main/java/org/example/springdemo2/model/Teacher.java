package org.example.springdemo2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
public class Teacher {
    private Long id;
    private String name;

    private List<Student> students;
}