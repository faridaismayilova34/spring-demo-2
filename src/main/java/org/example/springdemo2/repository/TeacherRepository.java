package org.example.springdemo2.repository;

import org.example.springdemo2.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}