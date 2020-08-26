package ru.geekbrains.persist;

//import javax.validation.constrains;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private Long id;

//    @NotNull(message = "Поле не должно быть пустым")
    private String name;

//    @NotNull(message = "Поле не должно быть пустым")
//    @Size(min = 4, max = 10,message = "Поле должно содержать от 4 до 10 символов")
    private String description;

    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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
}
