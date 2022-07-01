package com.example.products.Controller;

import com.example.products.Entity.ProductEntity;
import com.example.products.Repository.ProductRepository;
import com.example.products.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    public void MyController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello All";
    }

    @RequestMapping("/products")
    public ModelAndView showProduct() {

        List<ProductEntity> product = productService.findAllProduct();

        Map<String, Object> params = new HashMap<>();

        params.put("products", product);

        return new ModelAndView("showProduct", params);

    }

    @GetMapping("/viewProducts")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        System.out.println("products"+productService.findAllProduct());
        return "view-products";
    }


    }
