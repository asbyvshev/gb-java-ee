package ru.geekbrains.persist;

import java.util.Collections;
import java.util.List;

public class Cart {
    private Long id;
    private List<Product> products;

    public Cart(){}

    public Cart(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        if (products == null) {
            return Collections.emptyList();
        }
        return products;
    }

}
