package com.livarter.app.service;

import com.amazonaws.services.securityhub.model.Product;
import com.livarter.app.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private ProductMapper mapper;

    public List<Product> getProduct() {
        return mapper.getProduct();
    }

}
