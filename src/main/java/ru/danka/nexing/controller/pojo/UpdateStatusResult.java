package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.danka.nexing.model.UserStatus;

/**
 * Created by: Yaroslav Skrebets <sonic@c7x.dev>
 * Date: 7/7/2020: 5:23 PM
 */
@AllArgsConstructor
@Getter
@Setter
public class UpdateStatusResult {
    private Long id;
    private UserStatus previousStatus;
    private UserStatus currentStatus;
}
