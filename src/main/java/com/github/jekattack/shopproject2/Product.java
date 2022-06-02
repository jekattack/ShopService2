package com.github.jekattack.shopproject2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    private String name;
    private final String id = UUID.randomUUID().toString();

}
