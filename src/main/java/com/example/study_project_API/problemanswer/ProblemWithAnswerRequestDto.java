package com.example.study_project_API.problemanswer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemWithAnswerRequestDto {
    @NotNull(message = "사용자 ID는 필수입니다")
    private Long userId;
    
    @NotNull(message = "파트 ID는 필수입니다")
    private Long partId;
    
    @NotBlank(message = "제목은 필수입니다")
    private String title;
    
    @NotBlank(message = "답안은 필수입니다")
    private String answer;
    
    @NotBlank(message = "설명은 필수입니다")
    private String explanation;
}