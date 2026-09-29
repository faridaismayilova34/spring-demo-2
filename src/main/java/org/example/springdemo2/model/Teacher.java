package org.example.springdemo2.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
public class Teacher {
    private Long id;
    private String name;
    private String subject;
    private Integer age;
    private List<Student> students;
}