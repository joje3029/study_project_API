package com.example.study_project_API.problemanswer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemAnswerRepository extends JpaRepository<ProblemAnswer, Long> {
    Optional<ProblemAnswer> findByProblemId(Long problemId);
}