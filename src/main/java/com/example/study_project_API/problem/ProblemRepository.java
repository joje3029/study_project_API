package com.example.study_project_API.problem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    @Query(value = "SELECT * FROM problems ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Problem> findRandomProblems(@Param("count") int count);
}