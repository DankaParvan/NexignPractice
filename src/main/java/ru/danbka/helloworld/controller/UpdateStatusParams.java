package ru.danbka.helloworld.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.danbka.helloworld.model.UserStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateStatusParams {
    private Long id;
    private UserStatus status;
}
