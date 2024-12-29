package com.example.study_project_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.model.Bookmark;
import com.example.study_project_API.model.Image;
import com.example.study_project_API.model.Problem;
import com.example.study_project_API.model.User;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByUser(User user);
}