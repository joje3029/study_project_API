package com.example.study_project_API.problem;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProblemAnswerResponseDto {
    private Long id;
    private String answer;
    private String explanation;
    private String problemTitle;  // 문제 제목도 함께 반환
    
    @Builder
    public ProblemAnswerResponseDto(Long id, String answer, String explanation, String problemTitle) {
        this.id = id;
        this.answer = answer;
        this.explanation = explanation;
        this.problemTitle = problemTitle;
    }
}
