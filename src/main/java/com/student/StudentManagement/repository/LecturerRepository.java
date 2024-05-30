package com.student.StudentManagement.repository;

import com.student.StudentManagement.entities.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {
}
