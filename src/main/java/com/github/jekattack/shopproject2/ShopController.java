package com.github.jekattack.shopproject2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/getProducts")
    public List<Product> getAllProducts(){
        return shopService.listProducts();
    }

    @GetMapping("/getOrders")
    public List<Order> getAllOrders(){
        return shopService.listOrders();
    }

    @GetMapping("/getProduct/{name}")
    public Product getProduct(@PathVariable String name){
        return shopService.getProduct(name);
    }

    @PostMapping("/addOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody String[] ids){
        ArrayList<String> idsList = new ArrayList<String>(Arrays.asList(ids));
        shopService.addOrder(idsList);
    }

    @PostMapping("/addProduct/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@PathVariable String name){
        shopService.createProduct(name);
    }
}
