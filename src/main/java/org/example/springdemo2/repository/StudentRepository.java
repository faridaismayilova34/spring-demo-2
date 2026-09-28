package org.example.springdemo2.repository;

import org.example.springdemo2.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}