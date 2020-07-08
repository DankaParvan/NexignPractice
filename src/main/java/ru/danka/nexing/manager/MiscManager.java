package ru.danka.nexing.manager;

import ru.danka.nexing.model.UserStatus;
import ru.danka.nexing.model.User;

import java.util.Date;
import java.util.List;

public interface MiscManager {
    List<User> getStats(UserStatus status, Date startTime);
}
