package com.example.study_project_API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_project_API.model.Problem;
import com.example.study_project_API.service.ProblemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/problem-answers")
@RequiredArgsConstructor
public class ProblemAnswerController {//문제 답안 관련 CRUD
private final ProblemService problemService;
    
    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblems() {
        return ResponseEntity.ok(problemService.getAllProblems());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable Long id) {
        return ResponseEntity.ok(problemService.getProblemById(id));
    }
}