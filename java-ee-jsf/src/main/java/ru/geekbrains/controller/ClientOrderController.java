package ru.geekbrains.controller;

import ru.geekbrains.persist.ClientOrderReository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ClientOrderController implements Serializable {

    @Inject
    private ClientOrderReository orderReository;

//    создаем заказ
    public String createOrder(){return null;}
//    обновляем заказ
    public String updateOrder(){return null;}
//    удаляем заказ
    public String deleteOrder(){return null;}
//    сохраняем заказ
    public String saveOrder(){return null;}
}
