package com.github.jekattack.shopproject2;

import com.github.jekattack.shopproject2.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void shouldReturnSpecificProductForID(){
        //Given
        Product product1 = new Product("Television");
        Product product2 = new Product("Refridgerator");
        Product product3 = new Product("Chair");
        Product product4 = new Product("Computer");
        Product product5 = new Product("DVD");

        ArrayList<Product> inputProducts = new ArrayList<>();
        inputProducts.add(product1);
        inputProducts.add(product2);
        inputProducts.add(product3);
        inputProducts.add(product4);
        inputProducts.add(product5);

        ProductRepo productRepo = new ProductRepo(inputProducts);

        ArrayList<Product> productsOfOrder1 = new ArrayList<>();
        productsOfOrder1.add(product1);
        productsOfOrder1.add(product2);
        productsOfOrder1.add(product5);

        ArrayList<Product> productsOfOrder2 = new ArrayList<>();
        productsOfOrder2.add(product2);
        productsOfOrder2.add(product3);
        productsOfOrder2.add(product4);

        Order order1 = new Order(productsOfOrder1);
        Order order2 = new Order(productsOfOrder2);

        ArrayList<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);

        OrderRepo orderRepo = new OrderRepo(allOrders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //When
        String product3Id = product3.getId();
        Product expected = product3;
        Product actual = shopService.getProduct(product3Id);

        //Then
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void shouldReturnAllProducts(){
        //Given
        Product product1 = new Product("Television");
        Product product2 = new Product("Refridgerator");
        Product product3 = new Product("Chair");
        Product product4 = new Product("Computer");
        Product product5 = new Product("DVD");

        ArrayList<Product> inputProducts = new ArrayList<>();
        inputProducts.add(product1);
        inputProducts.add(product2);
        inputProducts.add(product3);
        inputProducts.add(product4);
        inputProducts.add(product5);

        ProductRepo productRepo = new ProductRepo(inputProducts);

        ArrayList<Product> productsOfOrder1 = new ArrayList<>();
        productsOfOrder1.add(product1);
        productsOfOrder1.add(product2);
        productsOfOrder1.add(product5);

        ArrayList<Product> productsOfOrder2 = new ArrayList<>();
        productsOfOrder2.add(product2);
        productsOfOrder2.add(product3);
        productsOfOrder2.add(product4);

        Order order1 = new Order(productsOfOrder1);
        Order order2 = new Order(productsOfOrder2);

        ArrayList<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);

        OrderRepo orderRepo = new OrderRepo(allOrders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //When
        List<Product> expected = inputProducts;
        List<Product> actual = shopService.listProducts();

        //Then
        Assertions.assertTrue(actual.containsAll(expected));
    }

    @Test
    void shouldAddOrderToOrderRepo(){
        //Given
        Product product1 = new Product("Television");
        Product product2 = new Product("Refridgerator");
        Product product3 = new Product("Chair");
        Product product4 = new Product("Computer");
        Product product5 = new Product("DVD");

        ArrayList<Product> inputProducts = new ArrayList<>();
        inputProducts.add(product1);
        inputProducts.add(product2);
        inputProducts.add(product3);
        inputProducts.add(product4);
        inputProducts.add(product5);

        ProductRepo productRepo = new ProductRepo(inputProducts);

        ArrayList<Product> productsOfOrder1 = new ArrayList<>();
        productsOfOrder1.add(product1);
        productsOfOrder1.add(product2);
        productsOfOrder1.add(product5);

        ArrayList<Product> productsOfOrder2 = new ArrayList<>();
        productsOfOrder2.add(product2);
        productsOfOrder2.add(product3);
        productsOfOrder2.add(product4);

        Order order1 = new Order(productsOfOrder1);
        Order order2 = new Order(productsOfOrder2);

        ArrayList<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);

        OrderRepo orderRepo = new OrderRepo(allOrders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //When
        ArrayList<String> productsOfOrder = new ArrayList<>();
        productsOfOrder.add(product1.getId());
        productsOfOrder.add(product2.getId());
        productsOfOrder.add(product5.getId());
        int sizeBefore = shopService.listOrders().size();
        shopService.addOrder(productsOfOrder);
        int sizeAfter = shopService.listOrders().size();

        //Then
        Assertions.assertEquals(sizeAfter,sizeBefore+1);
    }

    @Test
    void shouldReturnSpecificOrderForID(){
        //Given
        Product product1 = new Product("Television");
        Product product2 = new Product("Refridgerator");
        Product product3 = new Product("Chair");
        Product product4 = new Product("Computer");
        Product product5 = new Product("DVD");

        ArrayList<Product> inputProducts = new ArrayList<>();
        inputProducts.add(product1);
        inputProducts.add(product2);
        inputProducts.add(product3);
        inputProducts.add(product4);
        inputProducts.add(product5);

        ProductRepo productRepo = new ProductRepo(inputProducts);

        ArrayList<Product> productsOfOrder1 = new ArrayList<>();
        productsOfOrder1.add(product1);
        productsOfOrder1.add(product2);
        productsOfOrder1.add(product5);

        ArrayList<Product> productsOfOrder2 = new ArrayList<>();
        productsOfOrder2.add(product2);
        productsOfOrder2.add(product3);
        productsOfOrder2.add(product4);

        Order order1 = new Order(productsOfOrder1);
        Order order2 = new Order(productsOfOrder2);

        ArrayList<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);

        OrderRepo orderRepo = new OrderRepo(allOrders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //When
        String order1id = order1.getId();
        Order expected = order1;
        Order actual = shopService.getOrder(order1id);

        //Then
        Assertions.assertEquals(expected,actual);
    }


    @Test
    void shouldReturnAllOrders(){
        //Given
        Product product1 = new Product("Television");
        Product product2 = new Product("Refridgerator");
        Product product3 = new Product("Chair");
        Product product4 = new Product("Computer");
        Product product5 = new Product("DVD");

        ArrayList<Product> inputProducts = new ArrayList<>();
        inputProducts.add(product1);
        inputProducts.add(product2);
        inputProducts.add(product3);
        inputProducts.add(product4);
        inputProducts.add(product5);

        ProductRepo productRepo = new ProductRepo(inputProducts);

        ArrayList<Product> productsOfOrder1 = new ArrayList<>();
        productsOfOrder1.add(product1);
        productsOfOrder1.add(product2);
        productsOfOrder1.add(product5);

        ArrayList<Product> productsOfOrder2 = new ArrayList<>();
        productsOfOrder2.add(product2);
        productsOfOrder2.add(product3);
        productsOfOrder2.add(product4);

        Order order1 = new Order(productsOfOrder1);
        Order order2 = new Order(productsOfOrder2);

        ArrayList<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);

        OrderRepo orderRepo = new OrderRepo(allOrders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //When
        List<Order> expected = allOrders;
        List<Order> actual = shopService.listOrders();

        //Then
        Assertions.assertTrue(actual.containsAll(expected));
    }

    @Test
    void shouldThrowRuntimeException(){
        //Given
        Product product1 = new Product("Television");
        Product product2 = new Product("Refridgerator");
        Product product3 = new Product("Chair");
        Product product4 = new Product("Computer");
        Product product5 = new Product("DVD");

        ArrayList<Product> inputProducts = new ArrayList<>();
        inputProducts.add(product1);
        inputProducts.add(product2);
        inputProducts.add(product3);
        inputProducts.add(product4);
        inputProducts.add(product5);

        ProductRepo productRepo = new ProductRepo(inputProducts);

        ArrayList<Product> productsOfOrder1 = new ArrayList<>();
        productsOfOrder1.add(product1);
        productsOfOrder1.add(product2);
        productsOfOrder1.add(product5);

        ArrayList<Product> productsOfOrder2 = new ArrayList<>();
        productsOfOrder2.add(product2);
        productsOfOrder2.add(product3);
        productsOfOrder2.add(product4);

        Order order1 = new Order(productsOfOrder1);
        Order order2 = new Order(productsOfOrder2);

        ArrayList<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);

        OrderRepo orderRepo = new OrderRepo(allOrders);
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //When
        ArrayList<String> productsOfOrder = new ArrayList<>();
        productsOfOrder.add("NixMitID");
        productsOfOrder.add(product2.getId());
        productsOfOrder.add(product5.getId());
        int sizeBefore = shopService.listOrders().size();
        try{
            shopService.addOrder(productsOfOrder);
            Assertions.fail();
        }catch(RuntimeException r){
        }


    }

 }