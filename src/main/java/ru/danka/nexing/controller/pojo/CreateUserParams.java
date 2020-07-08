package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by: Yaroslav Skrebets <sonic@c7x.dev>
 * Date: 7/5/2020: 10:23 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateUserParams {
    private String username;
    private String email;

}
