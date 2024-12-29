package com.example.study_project_API.problem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemAnswerRequestDto {
    @NotNull(message = "문제 ID는 필수입니다")
    private Long problemId;
    
    @NotBlank(message = "답변은 필수입니다")
    private String answer;
    
    @NotBlank(message = "설명은 필수입니다")
    private String explanation;
}
