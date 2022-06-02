package com.github.jekattack.shopproject2;

import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {
    private HashMap<String, Order> orders = new HashMap<>();

    public OrderRepo(List<Order> orders){
        for(Order o : orders) this.orders.putIfAbsent(o.getId(), o);
    }

    public Optional<Order> get(String id){
        Optional<Order> orderReturn = Optional.of(orders.get(id));
        return orderReturn;
    }

    public List<Order> list(){
        return new ArrayList<>(orders.values());
    }

    public void add(Order newOrder){
        orders.putIfAbsent(newOrder.getId(), newOrder);
    }

}
