package edu.webclass.restapi.Product.Management.System.models.entities;

import edu.webclass.restapi.Product.Management.System.models.dto.ProductDto;
import edu.webclass.restapi.Product.Management.System.repository.ProductRepository;

public class Product {
    private String id;
    private String title;
    private int price;
    private String brand;


    public Product(String title, int price, String brand) {
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.id = "PRD_" + ProductRepository.lastId++;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public ProductDto dto(){
        return new ProductDto(this.getTitle(),this.brand,this.getPrice());

    }
}
