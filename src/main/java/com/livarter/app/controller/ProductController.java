package com.livarter.app.controller;

import com.amazonaws.services.securityhub.model.Product;
import com.livarter.app.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping(value ="/list")
    @ResponseBody
    public ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(service.getProduct(), HttpStatus.OK);
    }
}
