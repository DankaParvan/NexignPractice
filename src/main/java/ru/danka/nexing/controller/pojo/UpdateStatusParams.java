package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.danka.nexing.model.UserStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateStatusParams {
    private Long id;
    private UserStatus status;
}
