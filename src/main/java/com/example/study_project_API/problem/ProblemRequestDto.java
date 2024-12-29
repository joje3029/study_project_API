package com.example.study_project_API.problem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemRequestDto {
    @NotNull(message = "사용자 ID는 필수입니다")
    private Long userId;
    
    @NotNull(message = "파트 ID는 필수입니다")
    private Long partId;
    
    @NotBlank(message = "제목은 필수입니다")
    private String title;
}
