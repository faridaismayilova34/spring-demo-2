package org.example.springdemo2.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "teachers")
@EqualsAndHashCode(exclude = "teachers")
public class Student {
    private Long id;
    private String name;
    private Double score;
    private String email;

    private List<Teacher> teachers;
}