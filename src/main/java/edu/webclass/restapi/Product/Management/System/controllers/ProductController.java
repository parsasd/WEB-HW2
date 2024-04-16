package edu.webclass.restapi.Product.Management.System.controllers;

import edu.webclass.restapi.Product.Management.System.Exception.ProductNotFoundException;
import edu.webclass.restapi.Product.Management.System.models.dto.ProductDto;
import edu.webclass.restapi.Product.Management.System.models.entities.Product;
import edu.webclass.restapi.Product.Management.System.repository.ProductRepository;
import edu.webclass.restapi.Product.Management.System.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return ProductRepository.products;
    }

    @GetMapping("/list")
    public List<ProductDto> list(){
        return ProductRepository.products.stream().map(product -> new ProductDto(product.getTitle(), product.getBrand(), product.getPrice() )).toList();
    }

    @PostMapping("/add")
    public boolean addProduct(@RequestHeader("title") String title,@RequestHeader("brand") String brand,@RequestHeader int price){
        return productService.createProduct(title,brand,price);
    }

    @GetMapping("/{id}")
    public ProductDto getOneProduct(@PathVariable("id") String id) throws ProductNotFoundException {
        return productService.findProductById(id).dto();
    }

    @GetMapping("/name")
    public String sayName(){
        return productService.sayAppName();
    }
}
