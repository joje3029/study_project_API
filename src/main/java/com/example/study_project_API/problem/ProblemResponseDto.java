package com.example.study_project_API.problem;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProblemResponseDto {
    private Long id;
    private String title;
    private String partName;
    private String userName;
    
    @Builder
    public ProblemResponseDto(Long id, String title, String partName, String userName) {
        this.id = id;
        this.title = title;
        this.partName = partName;
        this.userName = userName;
    }
}
