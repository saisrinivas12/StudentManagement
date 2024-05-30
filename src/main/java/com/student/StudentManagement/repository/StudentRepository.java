package com.student.StudentManagement.repository;

import com.student.StudentManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Long> {
}
