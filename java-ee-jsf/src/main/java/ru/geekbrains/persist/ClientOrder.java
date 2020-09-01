package ru.geekbrains.persist;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_orders")
public class ClientOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private List<Product> products;

    @Column
    private byte status;

    public ClientOrder(){}

    public ClientOrder(Long id, List<Product> products, byte status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public ClientOrder(List<Product> products) {
        this.products = products;
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
