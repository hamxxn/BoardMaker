package com.example.boardmakers.global.error;


import com.example.boardmakers.global.error.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private String message;
    private HttpStatus status;

    public ErrorResponse(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
    }
    public static ErrorResponse from(final ErrorCode code) {
        return new ErrorResponse(code);
    }
}