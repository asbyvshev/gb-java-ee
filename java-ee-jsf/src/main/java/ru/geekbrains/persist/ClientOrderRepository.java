package ru.geekbrains.persist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class ClientOrderRepository {
//    реализация будет под JPA
    public void update(ClientOrder order) {
    }

    public void insert(ClientOrder order) {
    }

    public void delete(long id) {
    }
}
