package com.example.study_project_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_project_API.common.JsonResult;
import com.example.study_project_API.common.message.MessageHandler;
import com.example.study_project_API.common.type.MessageCrudType;
import com.example.study_project_API.dto.problem.ProblemAnswerResponseDto;
import com.example.study_project_API.dto.problem.ProblemResponseDto;
import com.example.study_project_API.service.ProblemAnswerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/problem-answers")
@RequiredArgsConstructor
@Slf4j
public class ProblemAnswerController {//문제 답안 관련 CRUD
	private final ProblemAnswerService problemAnswerService;
    private final MessageHandler messageHandler;

    @GetMapping("/get/{problemId}")
    public ResponseEntity<JsonResult> getProblemAnswer(@PathVariable Long problemId) {
        boolean isSuccess = false;
        ProblemAnswerResponseDto answer = null;
        
        try {
            answer = problemAnswerService.getProblemAnswer(problemId);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Failed to get problem answer", e);
        }
        
        return ResponseEntity.ok(
            messageHandler.getCrudMessageResult(isSuccess, MessageCrudType.READ, answer)
        );
    }
}