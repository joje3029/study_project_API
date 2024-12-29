package com.example.study_project_API.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_project_API.dto.problem.ProblemAnswerResponseDto;
import com.example.study_project_API.dto.problem.ProblemWithAnswerRequestDto;
import com.example.study_project_API.model.Part;
import com.example.study_project_API.model.Problem;
import com.example.study_project_API.model.ProblemAnswer;
import com.example.study_project_API.model.User;
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
    
    @Transactional
    public void createProblemWithAnswer(ProblemWithAnswerRequestDto requestDto) {
        // 1. 문제 생성
        User user = userRepository.findById(requestDto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
            
        Part part = partRepository.findById(requestDto.getPartId())
            .orElseThrow(() -> new RuntimeException("Part not found"));
            
        Problem problem = Problem.builder()
            .user(user)
            .part(part)
            .title(requestDto.getTitle())
            .build();
        
        Problem savedProblem = problemRepository.save(problem);
        
        // 2. 답안 생성
        ProblemAnswer answer = ProblemAnswer.builder()
            .problem(savedProblem)
            .answer(requestDto.getAnswer())
            .explanation(requestDto.getExplanation())
            .build();
        
        problemAnswerRepository.save(answer);
    }
}