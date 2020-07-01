package ru.danka.helloworld.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/sayHi")
    public String sayHi(){
        return "Hi";
    }
}
