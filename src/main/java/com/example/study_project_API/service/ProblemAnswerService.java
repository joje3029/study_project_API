package com.example.study_project_API.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_project_API.dto.problem.ProblemAnswerResponseDto;
import com.example.study_project_API.model.ProblemAnswer;
import com.example.study_project_API.repository.ProblemAnswerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)  // 읽기 전용 트랜잭션
public class ProblemAnswerService {
    private final ProblemAnswerRepository problemAnswerRepository;
    
    public ProblemAnswerResponseDto getProblemAnswer(Long problemId) {
        // 문제 ID로 답안을 조회
        ProblemAnswer answer = problemAnswerRepository.findByProblemId(problemId)
            .orElseThrow(() -> new RuntimeException("Answer not found for problem: " + problemId));
            
        // 엔티티를 DTO로 변환하여 반환
        return ProblemAnswerResponseDto.builder()
            .id(answer.getId())
            .answer(answer.getAnswer())
            .explanation(answer.getExplanation())
            .problemTitle(answer.getProblem().getTitle())
            .build();
    }
}