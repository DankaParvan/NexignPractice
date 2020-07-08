package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.danka.nexing.model.UserStatus;

@AllArgsConstructor
@Getter
@Setter
public class UpdateStatusResult {
    private Long id;
    private UserStatus previousStatus;
    private UserStatus currentStatus;
}
