package com.example.study_project_API.part;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.user.User;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByUser(User user);
}