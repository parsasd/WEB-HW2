package edu.webclass.restapi.Product.Management.System.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    public String productName;
    public String productBrand;
    public int productPrice;
}
