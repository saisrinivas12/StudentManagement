package com.student.StudentManagement.repository;

import com.student.StudentManagement.entities.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface FeesRepository extends JpaRepository<Fees,Integer> {
}
