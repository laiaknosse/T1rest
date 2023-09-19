package com.example.testT1rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class TestT1restApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestT1restApplication.class, args);
    }


}

//curl -X POST -H "Content-Type: application/json" -d 'aaaaabcccc' http://localhost:8080/analyze
