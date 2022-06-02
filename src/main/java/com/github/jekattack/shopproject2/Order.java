package com.github.jekattack.shopproject2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private final String id = UUID.randomUUID().toString();
    private ArrayList<Product> products;

}
