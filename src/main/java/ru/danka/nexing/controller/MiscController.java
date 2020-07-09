package ru.danka.nexing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danka.nexing.controller.pojo.StatsParams;
import ru.danka.nexing.controller.pojo.StatsResult;
import ru.danka.nexing.manager.MiscService;
import ru.danka.nexing.model.User;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/misc")
public class MiscController {
    @Autowired
    private MiscService miscService;

    @PostMapping(value = "/stats")
    public StatsResult calculateStats(@RequestBody StatsParams params) {
        List<User> users = miscService.getStats(params.getStatus(), params.getTime());
        return new StatsResult(System.currentTimeMillis(),
                users.stream().map(User::getId).collect(Collectors.toList()));
    }
}
