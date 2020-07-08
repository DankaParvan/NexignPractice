package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.danka.nexing.model.UserStatus;

/**
 * Created by: Yaroslav Skrebets <sonic@c7x.dev>
 * Date: 7/7/2020: 5:08 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateStatusParams {
    private Long id;
    private UserStatus status;
}
