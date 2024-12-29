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
@RequestMapping("/image")
@RequiredArgsConstructor
public class ProblemSubmissionController {
private final ProblemService problemService;
    //점수 등록, 등록시 등록 일자 함께 등록, sql로 일자 함꼐 등록, 
}