package com.example.products.Controller;

import com.example.products.Dto.ProductDto;
import com.example.products.Entity.ProductEntity;
import com.example.products.Mapper.ProductMapper;
import com.example.products.Repository.ProductRepository;
import com.example.products.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    ProductMapper mapper;

    @Autowired
    public void MyController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello All";
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String findAll(Model model) {

        List<ProductDto> products = mapper.modelsToDtos(productService.findAllProduct());
        System.out.println("Products :"+products);
        model.addAttribute("products", products);
        return "showProduct";
    }

    @GetMapping("/products")
    public ModelAndView showProduct() {

        List<ProductEntity> product = productService.findAllProduct();
        System.out.println("ProductList : "+product);
        Map<String, Object> params = new HashMap<>();

        params.put("products", product);
        ModelAndView model  = new ModelAndView("showProduct", params);
        System.out.println("Model:"+model);
        return model;

    }

    @GetMapping("/viewProducts")
    public ModelAndView viewProducts() {
//        model.addAttribute("products", productService.findAllProduct());
        Map<String, Object> params = new HashMap<>();

        params.put("products", productService.findAllProduct());
        System.out.println("products"+productService.findAllProduct());
        ModelAndView model  = new ModelAndView("view-products", params);
        return model;
    }


}