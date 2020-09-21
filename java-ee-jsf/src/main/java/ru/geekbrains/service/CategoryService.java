package ru.geekbrains.service;

import ru.geekbrains.persist.Category;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.Optional;

@Local
public interface CategoryService {

    void insert(Category category);

    void update(Category category);

    void delete(long id);

    Optional<Category> findById(long id);

    List<Category> findAll();

    Optional<Category> findByName(String name);
}
