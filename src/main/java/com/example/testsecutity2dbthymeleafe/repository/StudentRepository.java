package com.example.testsecutity2dbthymeleafe.repository;



import com.example.testsecutity2dbthymeleafe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SudentRepository extends JpaRepository<Student, Long> {
    }
