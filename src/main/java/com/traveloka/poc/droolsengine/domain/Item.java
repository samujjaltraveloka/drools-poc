package com.traveloka.poc.droolsengine.domain;

import lombok.Data;

@Data
public class Item {
    private String name;
    private String type;
    private int discount;
    private int price;
}
