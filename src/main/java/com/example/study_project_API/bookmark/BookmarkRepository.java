package com.example.study_project_API.bookmark;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.problem.Problem;
import com.example.study_project_API.user.User;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Problem> findByUser(User user);
}