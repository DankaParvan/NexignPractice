package ru.danka.nexing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danka.nexing.controller.pojo.CreateUserParams;
import ru.danka.nexing.controller.pojo.UpdateStatusParams;
import ru.danka.nexing.controller.pojo.UpdateStatusResult;
import ru.danka.nexing.manager.UserManager;
import ru.danka.nexing.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserManager userManager;


    @GetMapping("/get")
    public Optional<User> getUser(@RequestParam(value = "id") Long id) {
        return userManager.getUser(id);
    }

    @PostMapping(value = "/create")
    public Long createUser(@RequestBody CreateUserParams params) {
        return userManager.createUser(params.getUsername(), params.getEmail());
    }

    @PostMapping(value = "/status/update")
    public UpdateStatusResult updateStatus(@RequestBody UpdateStatusParams params) {
        return new UpdateStatusResult(params.getId(), userManager.updateStatus(params.getId(), params.getStatus()), params.getStatus());
    }
}
