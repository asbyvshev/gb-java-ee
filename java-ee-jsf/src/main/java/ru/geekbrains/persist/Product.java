package ru.geekbrains.persist;

//import javax.validation.constrains;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "Поле не должно быть пустым")
    @Column(length = 128, nullable = false)
    private String name;

//    @NotNull(message = "Поле не должно быть пустым")
//    @Size(min = 4, max = 10,message = "Поле должно содержать от 4 до 10 символов")
    private String description;

    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List <ClientOrder> orders;

    public Product() {
    }

    public Product( String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(Long id, String name, String description, BigDecimal price, Category category) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ClientOrder> getOrders() {
        if (orders == null){
            return Collections.emptyList();
        }
        return orders;
    }

    public void setOrders(List<ClientOrder> orders) {
        this.orders = orders;
    }
}
