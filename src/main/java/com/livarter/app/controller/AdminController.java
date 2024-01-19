package com.livarter.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 황수영
 * @fileName : AdminController
 * @since : 2024-01-19
 */

@RequestMapping("/")
@RestController
public class AdminController {

    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Health Check : 서버 정상!");
    }
}