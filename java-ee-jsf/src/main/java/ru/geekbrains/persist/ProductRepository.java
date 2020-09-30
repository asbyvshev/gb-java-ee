package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.service.ProductRepr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @EJB
    private CategoryRepository categoryRepository;

    public ProductRepository() {
    }

    public void insert(Product product) {
        logger.info("Inserting new product");
        em.persist(product);
    }

    public void update(Product product) {
        logger.info("Updating product");
        em.merge(product);
    }

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

    public List<Product> findByCategoryId(long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new WebApplicationException(Response.Status.NOT_FOUND));
        List<Product> products = em.createQuery("from Product p where p.category = :category",Product.class)
                .setParameter("category",category)
                .getResultList();
        return products;
    }

    public Optional<Product> findByName(String name){
        Product product = em.createQuery("from Product p where p.name = :name",Product.class)
                .setParameter("name",name)
                .getSingleResult();
        if (product != null) {
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
