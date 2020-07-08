package ru.danka.nexing.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Created by: Yaroslav Skrebets <sonic@c7x.dev>
 * Date: 7/7/2020: 5:32 PM
 */
@AllArgsConstructor
@Getter
public class StatsResult {
    private long id;
    private List<Long> userList;
}
