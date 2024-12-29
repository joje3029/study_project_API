package com.example.study_project_API.problem;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_project_API.common.JsonResult;
import com.example.study_project_API.common.message.MessageHandler;
import com.example.study_project_API.common.type.MessageCrudType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/problems")
@RequiredArgsConstructor
@Slf4j
public class ProblemController {//문제 자체의 CRUD, 이렇게 나누면 SRP(단일책임원칙에 부합함)
	private final ProblemService problemService;
	private final MessageHandler messageHandler;

    @PostMapping("/add")//문제 등록
    public ResponseEntity<JsonResult> addProblem(@RequestBody ProblemRequestDto ProblemRequestDto) {
        boolean isSuccess = false;
        ProblemRequestDto response = null;
        
        try {
            problemService.createProblem(ProblemRequestDto);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Failed to create problem", e.getMessage());
        }
        
        return ResponseEntity.ok(
                messageHandler.getCrudMessageResult(isSuccess, MessageCrudType.CREATE, null)  // data는 null
        );
    }
    
    @GetMapping("/get")//문제 풀기의 문제 가져오기
    public ResponseEntity<JsonResult> getProblems(@RequestBody ProblemRequestDto ProblemRequestDto) {
        boolean isSuccess = false;
        List<ProblemResponseDto> problems = null;
        
        try {
            problems = problemService.getRandomProblems(100); // 랜덤 100개
            isSuccess = true;
        } catch (Exception e) {
            log.error("Failed to get problems", e.getMessage());
        }
        
        return ResponseEntity.ok(
            messageHandler.getCrudMessageResult(isSuccess, MessageCrudType.READ, problems)
        );
    }


    
}