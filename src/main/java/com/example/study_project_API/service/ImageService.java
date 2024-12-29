package com.example.study_project_API.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.study_project_API.model.Problem;
import com.example.study_project_API.repository.ProblemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ProblemRepository problemRepository;
    
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }
    
    public Problem getProblemById(Long id) {
        return problemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Problem not found"));
    }
}