package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateful;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartServiceImpl implements CartService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private List<ProductRepr> productReprList = new ArrayList<>();

    @Override
    public void add(ProductRepr productRepr) {
        productReprList.add(productRepr);
    }

    @Override
    public void delete(ProductRepr productRepr) {
        productReprList.remove(productRepr);
    }

    @Override
    public List<ProductRepr> getAllProducts() {
//        return new ArrayList<>(productReprList);
        return productReprList;
    }

    @Override
    public BigDecimal getTotalCost() {
        BigDecimal total = BigDecimal.valueOf(0);
        for (ProductRepr p:productReprList) {
            total.add(p.getPrice());
        }
        return total;
    }
}
