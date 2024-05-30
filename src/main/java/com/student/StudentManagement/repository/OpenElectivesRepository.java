package com.student.StudentManagement.repository;

import com.student.StudentManagement.entities.OpenElectives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OpenElectivesRepository extends JpaRepository<OpenElectives,Integer> {

}
