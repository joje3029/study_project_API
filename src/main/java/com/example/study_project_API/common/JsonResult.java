package com.example.study_project_API.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JsonResult {
    private int code;       // 상태 코드
    private String message; // 응답 메시지
    private Object data;    // 실제 데이터

    public JsonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}