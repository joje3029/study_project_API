package com.example.study_project_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.model.Problem;
import com.example.study_project_API.model.User;

// @Repository
// public interface ProblemRepository extends JpaRepository<Problem, Long> {
//     List<Problem> findByUser(User user);
// }

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    @Query(value = "SELECT * FROM problems ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Problem> findRandomProblems(@Param("count") int count);
}