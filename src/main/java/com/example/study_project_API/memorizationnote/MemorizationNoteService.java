package com.example.study_project_API.memorizationnote;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.study_project_API.problem.Problem;
import com.example.study_project_API.problem.ProblemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemorizationNoteService {
    private final ProblemRepository problemRepository;
    
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }
    
    public Problem getProblemById(Long id) {
        return problemRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Problem not found"));
    }
}