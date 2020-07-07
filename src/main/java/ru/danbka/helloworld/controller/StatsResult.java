package ru.danbka.helloworld.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StatsResult {
    private long id;
    private List<Long> userList;
}
