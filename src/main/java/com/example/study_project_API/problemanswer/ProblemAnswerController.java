package com.example.study_project_API.problemanswer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_project_API.common.JsonResult;
import com.example.study_project_API.common.message.MessageHandler;
import com.example.study_project_API.common.type.MessageCrudType;
import com.example.study_project_API.problem.ProblemAnswerResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/problem-answers")
@RequiredArgsConstructor
@Slf4j
public class ProblemAnswerController {//문제 답안 관련 CRUD
	private final ProblemAnswerService problemAnswerService;
    private final MessageHandler messageHandler;

    @GetMapping("/get/{problemId}")//정답 가져오기
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
    
    //문제 등록시 정답 같이 등록하기
    @PostMapping("/add")
    public ResponseEntity<JsonResult> addAnswer(@RequestBody ProblemWithAnswerRequestDto requestDto) {
        boolean isSuccess = false;
        
        try {
            problemAnswerService.createProblemWithAnswer(requestDto);
            isSuccess = true;
        } catch (Exception e) {
            log.error("Failed to create problem with answer", e);
        }
        
        return ResponseEntity.ok(
            messageHandler.getCrudMessageResult(isSuccess, MessageCrudType.CREATE, null)
        );
    }
    
}