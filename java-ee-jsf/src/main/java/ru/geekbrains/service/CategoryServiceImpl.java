package ru.geekbrains.service;

import ru.geekbrains.persist.Category;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class CategoryServiceImpl implements CategoryService {

    // TODO: 21.09.2020 реализовать сервис 
    
    @Override
    public void insert(Category category) {
        
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Optional<Category> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return Optional.empty();
    }
}
