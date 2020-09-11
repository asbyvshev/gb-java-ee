package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartServiceImpl implements CartService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private List<ProductRepr> productReprList = new ArrayList<>();

    @Override
    public void add(ProductRepr productRepr) {
        // TODO
    }

    @Override
    public void delete(ProductRepr productRepr) {

    }

    @Override
    public List<ProductRepr> getAllProducts() {
        return null; // TODO
    }
}
