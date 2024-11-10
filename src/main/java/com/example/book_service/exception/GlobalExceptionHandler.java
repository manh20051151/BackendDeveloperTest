package com.example.book_service.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // đánh dấu lớp này là nơi xử lý ngoại lệ toàn cục cho tất cả các controller trong ứng dụng
public class GlobalExceptionHandler {
    // xử lý các ngoại lệ kiểu RuntimeException và trả về phản hồi với mã lỗi 400 (bad request)
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handLingRuntimeException(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
    // xử lý ngoại lệ khi có lỗi xác thực đối với các đối tượng được đánh dấu @Valid
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handLingValid(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }
}
