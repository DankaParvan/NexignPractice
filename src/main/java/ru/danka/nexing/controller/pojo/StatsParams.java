package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.danka.nexing.model.UserStatus;

import java.util.Date;

@AllArgsConstructor
@Getter
public class StatsParams {
    private UserStatus status;
    private Date time;
}
