package org.example.springdemo2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String subject;
    private Integer age;

    @ManyToMany(mappedBy = "teachers")
    private List<StudentEntity> students = new ArrayList<>();
}
































//@Entity
//@Table(name = "teachers")
//public class TeacherEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String subject;
//    private Integer age;
//
//    @ManyToMany(mappedBy = "teachers",fetch = FetchType.LAZY)
//    private List<StudentEntity> students = new ArrayList<>();
//
//
//    public TeacherEntity() {
//    }
//
//    public TeacherEntity(Long id, String name, String subject, Integer age, List<StudentEntity> students) {
//        this.id = id;
//        this.name = name;
//        this.subject = subject;
//        this.age = age;
//        this.students = students;
//    }
//
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
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public List<StudentEntity> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<StudentEntity> students) {
//        this.students = students;
//    }
//}