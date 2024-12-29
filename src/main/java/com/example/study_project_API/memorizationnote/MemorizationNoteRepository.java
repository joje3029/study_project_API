package com.example.study_project_API.memorizationnote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.study_project_API.image.Image;
import com.example.study_project_API.user.User;

@Repository
public interface MemorizationNoteRepository extends JpaRepository<Image, Long> {
    List<Image> findByUser(User user);
}