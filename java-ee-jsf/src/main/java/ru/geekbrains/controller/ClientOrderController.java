package ru.geekbrains.controller;

import ru.geekbrains.persist.ClientOrder;
import ru.geekbrains.persist.ClientOrderRepository;
import ru.geekbrains.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ClientOrderController implements Serializable {

    @Inject
    private ClientOrderRepository orderRepository;
    
    private ClientOrder order;

    public ClientOrder getOrder() {
        return order;
    }

    public void setOrder(ClientOrder order) {
        this.order = order;
    }

    //    создаем заказ
    public String createOrder(List<Product> products){
        this.order = new ClientOrder(products);
        return "/client_order.xhtml?faces-redirect=true";
    }
    
//    обновляем заказ
    public String editOrder(ClientOrder order){
        this.order = order;
        return "/client_order.xhtml?faces-redirect=true"; 
    }
    
//    удаляем заказ
    public String deleteOrder(ClientOrder order){
        orderRepository.delete(order.getId());
        return "/client_order.xhtml?faces-redirect=true";
    }
    
//    сохраняем заказ
    public String saveOrder(){
        if (order.getId() != null) {
            orderRepository.update(order);
        } else {
            orderRepository.insert(order);
        }
        return "/client_order.xhtml?faces-redirect=true";
    }
}
