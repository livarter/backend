package com.livarter.app.mapper;

import com.amazonaws.services.securityhub.model.Product;

import java.util.List;

public interface ProductMapper {
    public List<Product> getProduct();
}