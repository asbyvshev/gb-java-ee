package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartService {

    void add(ProductRepr productRepr);

    void delete(ProductRepr productRepr);

    List<ProductRepr> getAllProducts();
}
