package ru.geekbrains.controller;

import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public List<ProductRepr> getAllProducts() {
        return cartService.getAllProducts();
    }

    public void add(ProductRepr productRepr) {
        cartService.add(productRepr);
    }

    public void delete(ProductRepr productRepr) {
        cartService.delete(productRepr);
    }

    public BigDecimal getTotalCost () {
        return cartService.getTotalCost();
    }

}