package com.springboot.valid_exception.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String name;
    private int price;
    private int stock;

    public ProductDto(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}