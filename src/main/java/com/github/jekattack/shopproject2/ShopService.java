package com.github.jekattack.shopproject2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public void createProduct(String name){
        productRepo.create(name);
    }

    public Product getProduct(String id){
        return productRepo.get(id).get();
    }

    public List<Product> listProducts(){
        return productRepo.list();
    }

    public void addOrder(ArrayList<String> productIds){
        ArrayList<Product> productsOfOrder = new ArrayList<>();
        for(String id : productIds){
            Optional<Product> product = productRepo.get(id);
            if (product.isEmpty()) {
                throw new RuntimeException();
            }
            productsOfOrder.add(product.get());
        }

        Order newOrder = new Order(productsOfOrder);
        orderRepo.add(newOrder);
    }

    public Order getOrder(String id){
        return orderRepo.get(id).get();
    }

    public List<Order> listOrders(){
        return orderRepo.list();
    }
}
