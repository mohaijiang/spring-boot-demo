package com.newtouch.mohaijiang.springbootdemo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity runtimeExceptionHandler(RuntimeException runtimeException) throws Exception {
        log.error("catch runtimeException: {}",  runtimeException.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", runtimeException.getMessage());
        return ResponseEntity.status(409).body(map);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity globalExceptionHandler(Exception exception) throws Exception {
        log.error("catch exception: {}",  exception.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("errorMessage", exception.getMessage());
        return ResponseEntity.status(500).body(map);
    }

}
