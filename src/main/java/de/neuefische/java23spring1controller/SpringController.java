package de.neuefische.java23spring1controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hallo, Welt!";
    }

    @GetMapping("/api/hello/{name}")
    public String sayHello2(@PathVariable String name) {
        return "Hallo " + name;
    }



}
