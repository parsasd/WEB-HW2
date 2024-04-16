package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.Exception.ProductNotFoundException;
import edu.webclass.restapi.Product.Management.System.models.dto.ProductDto;
import edu.webclass.restapi.Product.Management.System.models.entities.Product;
import edu.webclass.restapi.Product.Management.System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Value("${spring.application.name}")
    private String appName;

    @PostMapping
    public boolean createProduct(String title, String brand, int price){
        return productRepository.createNewProduct(new Product(title,price,brand));
    }

    public Product findProductById(String id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }else{
            throw new  ProductNotFoundException("can not find Product with id " + id);
        }
    }

    public String sayAppName(){
        return appName;
    }
}
