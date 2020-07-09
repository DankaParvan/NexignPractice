package ru.danka.nexing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danka.nexing.controller.pojo.CreateUserParams;
import ru.danka.nexing.controller.pojo.UpdateStatusParams;
import ru.danka.nexing.controller.pojo.UpdateStatusResult;
import ru.danka.nexing.manager.UserService;
import ru.danka.nexing.model.User;

@RestController
@RequestMapping("/user")
public abstract class UserController implements UserService {
    @Autowired
    UserService userService;


    @GetMapping("/get")
    public User getUser(@RequestParam(value = "id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "/create")
    public Long createUser(@RequestBody CreateUserParams params) {
        return userService.createUser(params.getUsername(), params.getEmail());
    }

    @PostMapping(value = "/status/update")
    public UpdateStatusResult updateStatus(@RequestBody UpdateStatusParams params) {
        return new UpdateStatusResult(params.getId(), userService.updateStatus(params.getId(), params.getStatus()), params.getStatus());
    }
}
