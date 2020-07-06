package ru.danbka.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danbka.helloworld.model.User;
import ru.danbka.helloworld.model.UserRepository;


@RestController
public class HelloWorldController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hi";
    }

    @GetMapping("/test")
    public String test() {

        for (User user : userRepository.findAll()) {
            return user.getEmail();
        }
        return "nothing";
    }

    @PostMapping(value = "/user/create")
    public Long createUser(@RequestBody CreateUserParams params) {
        return userRepository.save(new User(null, params.getUsername(), params.getEmail())).getId();
    }
}
