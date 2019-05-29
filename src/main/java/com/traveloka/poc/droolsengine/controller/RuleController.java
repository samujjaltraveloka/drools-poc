package com.traveloka.poc.droolsengine.controller;


import com.traveloka.poc.droolsengine.Service.PriceCalculator;
import com.traveloka.poc.droolsengine.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RuleController {

    @Autowired
    private PriceCalculator priceCalculator;

    @GetMapping("/hello")
    public ResponseEntity<String> getTestResponse(){
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/price")
    public ResponseEntity<Item> getItemPrice(@RequestBody Item item){
        log.info("Received Request for item {}", item);
        return ResponseEntity.ok(priceCalculator.setDiscount(item));
    }
}
