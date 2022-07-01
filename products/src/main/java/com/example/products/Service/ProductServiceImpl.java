package com.example.products.Service;

import com.example.products.Entity.ProductEntity;
import com.example.products.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> findAllProduct(){
        return (List<ProductEntity>) productRepository.findAll();
    }
}
