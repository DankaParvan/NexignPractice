package ru.danbka.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danbka.helloworld.model.User;
import ru.danbka.helloworld.model.UserRepository;
import ru.danbka.helloworld.model.UserStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/user/get")
    public Optional<User> getUser(@RequestParam(value = "id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping(value = "/user/create")
    public Long createUser(@RequestBody CreateUserParams params) {
        return userRepository.save(new User(null, params.getUsername(), params.getEmail(), UserStatus.UNKNOWN, new Date(0))).getId();
    }

    @PostMapping(value = "/user/status/update")
    public UpdateStatusResult updateStatus(@RequestBody UpdateStatusParams params) {
        Optional<User> userById = userRepository.findById(params.getId());
        if (userById.isPresent()) {
            User user = userById.get();
            UserStatus previous = user.getStatus();
            user.setStatus(params.getStatus());
            user.setLastChangeDate(new Date());
            userRepository.save(user);
            return new UpdateStatusResult(null, user.getId(), previous, user.getStatus());
        } else {
            return new UpdateStatusResult("unknown user.", null, null, null);
        }
    }

    @PostMapping(value = "/misc/stats")
    public StatsResult calculateStats(@RequestBody StatsParams params) {
        List<User> users = userRepository.findUserByStatusEqualsAndLastChangeDateAfter(params.getStatus(),
                params.getTime() == null ? new Date(0) : params.getTime());
        return new StatsResult(System.currentTimeMillis(),
                users.stream().map(User::getId).collect(Collectors.toList()));
    }

}
