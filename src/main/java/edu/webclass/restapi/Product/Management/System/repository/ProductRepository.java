package edu.webclass.restapi.Product.Management.System.repository;

import edu.webclass.restapi.Product.Management.System.models.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductRepository {
    public static ArrayList<Product> products = new ArrayList<Product>();
    public static int lastId=0;

    public ProductRepository() {
        products.add(new Product("Shampoo",100000,"Golrang"));
        products.add(new Product("Mobile",50000000,"Samsung"));
        products.add(new Product("Cake",20000,"Titop!"));
    }
    public boolean createNewProduct(Product product){
        this.products.add(product);
        if(products.size()==ProductRepository.lastId){
            return true;
        }else{
            return false;
        }
    }


    public Optional<Product> findById(String id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
