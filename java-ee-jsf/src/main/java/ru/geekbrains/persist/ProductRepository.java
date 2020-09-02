package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Named
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
       if (this.findAll().isEmpty()) {
            logger.info("No products in DB. Initializing.");

           this.insert(new Product(null, "Apple Macbook pro 2015", "Apple profession laptop", new BigDecimal(3000)));
           this.insert(new Product(null, "Apple Macbook air 2015", "Apple netbook", new BigDecimal(2000)));
           this.insert(new Product(null, "Apple iPad", "Apple tablet", new BigDecimal(1000)));
        }
    }

    @Transactional
    public void insert(Product product) {
        logger.info("Inserting new product");
        em.persist(product);
    }

    @Transactional
    public void update(Product product) {
        logger.info("Updating product");
        em.merge(product);
    }

    @Transactional
    public void delete(long id) {
        logger.info("Deleting product");
        Product product = em.find(Product.class,id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Optional<Product> findById(long id) {
        Product product = em.find(Product.class,id);
        if (product != null) {
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public List<Product> findAll() {
        return em.createQuery("from Product",Product.class).getResultList();
    }
}
