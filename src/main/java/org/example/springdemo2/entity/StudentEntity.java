package org.example.springdemo2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "teachers")
@EqualsAndHashCode(exclude = "teachers")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double score;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teachers = new ArrayList<>();
}





































//@Entity
//@Table(name = "students")
//public class StudentEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private Double score;
//    private String email;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "student_teacher",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id")
//    )
//    private List<TeacherEntity> teachers = new ArrayList<>();
//
//
//    public StudentEntity() {
//    }
//
//    public StudentEntity(Long id, String name, Double score, String email, List<TeacherEntity> teachers) {
//        this.id = id;
//        this.name = name;
//        this.score = score;
//        this.email = email;
//        this.teachers = teachers;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getScore() {
//        return score;
//    }
//
//    public void setScore(Double score) {
//        this.score = score;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<TeacherEntity> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(List<TeacherEntity> teachers) {
//        this.teachers = teachers;
//    }
//}