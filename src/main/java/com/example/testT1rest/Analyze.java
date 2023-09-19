package com.example.testT1rest;

import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Analyze {


    @PostMapping("/analyze")
    public Map<String, Integer> analyze(@RequestBody String input) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            result.merge(String.valueOf(c), 1, Integer::sum);
        }

        result = result.entrySet().stream()
                .sorted(Comparator.comparingInt(m -> -m.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
                    throw new AssertionError();
                }, LinkedHashMap::new));


        return result;
    }
}
