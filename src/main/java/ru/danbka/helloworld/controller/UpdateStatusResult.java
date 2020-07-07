package ru.danbka.helloworld.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.danbka.helloworld.model.UserStatus;

@AllArgsConstructor
@Getter
@Setter
public class UpdateStatusResult {
    private String error;
    private Long id;
    private UserStatus previousStatus;
    private UserStatus currentStatus;
}
