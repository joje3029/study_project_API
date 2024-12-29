package com.example.study_project_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.model.Part;
import com.example.study_project_API.model.User;

@Repository
public interface RoblemSubmissionRepository extends JpaRepository<Part, Long> {
    List<Part> findByUser(User user);
}