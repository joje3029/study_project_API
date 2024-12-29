package com.example.study_project_API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.model.ProblemAnswer;

@Repository
public interface ProblemAnswerRepository extends JpaRepository<ProblemAnswer, Long> {
    Optional<ProblemAnswer> findByProblemId(Long problemId);
}