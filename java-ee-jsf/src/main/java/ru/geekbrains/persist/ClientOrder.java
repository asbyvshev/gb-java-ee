package ru.geekbrains.persist;

import java.util.ArrayList;
import java.util.List;

public class ClientOrder {

    private Long id;
    private List<Product> products;
    private byte status;

    public ClientOrder(){}

    public ClientOrder(Long id, List<Product> products, byte status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
}
