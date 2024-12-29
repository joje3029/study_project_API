package com.example.study_project_API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_project_API.model.User;
import com.example.study_project_API.service.UserService;
import com.example.study_project_API.common.JsonResult;
import com.example.study_project_API.common.message.MessageHandler;
import com.example.study_project_API.common.type.MessageCrudType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final MessageHandler messageHandler;
    
    @GetMapping
    public ResponseEntity<JsonResult> getAllUsers() {
        boolean isSuccess = false;
        List<User> users = null;
        
        try {
            users = userService.getAllUsers();
            isSuccess = true;
        } catch (Exception e) {
            log.error("Failed to get users", e);
        }
        
        return ResponseEntity.ok(
            messageHandler.getCrudMessageResult(isSuccess, MessageCrudType.READ, users)
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}