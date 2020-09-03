package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Named
public class ClientOrderRepository {
// TODO: 03.09.2020  ui + nav bar
private static final Logger logger = LoggerFactory.getLogger(ClientOrderRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Inject
    private UserTransaction ut;

    public ClientOrderRepository() {
    }

    @Transactional
    public void insert(ClientOrder order) {
        em.persist(order);
    }

    @Transactional
    public void update(ClientOrder order) {
        em.merge(order);
    }

    @Transactional
    public void delete(long id) {
        ClientOrder order = em.find(ClientOrder.class, id);
        if (order != null) {
            em.remove(order);
        }
    }

    public Optional<ClientOrder> findById(long id) {
        ClientOrder order = em.find(ClientOrder.class, id);
        if (order != null) {
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public List<ClientOrder> findAll() {
        return em.createQuery("from ClientOrder", ClientOrder.class)
                .getResultList();
    }

    public Optional<ClientOrder> findByName(String name) {
        ClientOrder order = em.createQuery("from ClientOrder c where c.name = :name", ClientOrder.class)
                .setParameter("name", name)
                .getSingleResult();
        if (order != null) {
            return Optional.of(order);
        } else {
            return Optional.empty();
        }
    }
}
