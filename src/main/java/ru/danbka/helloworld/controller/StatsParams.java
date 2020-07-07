package ru.danbka.helloworld.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.danbka.helloworld.model.UserStatus;

import java.util.Date;

@AllArgsConstructor
@Getter
public class StatsParams {
    private UserStatus status;
    private Date time;
}
