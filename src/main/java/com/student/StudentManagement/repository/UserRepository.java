package com.student.StudentManagement.repository;

import com.student.StudentManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
