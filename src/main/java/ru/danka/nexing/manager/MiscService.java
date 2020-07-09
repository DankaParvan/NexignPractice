package ru.danka.nexing.manager;

import ru.danka.nexing.model.User;
import ru.danka.nexing.model.UserStatus;

import java.util.Date;
import java.util.List;

public interface MiscService {
    List<User> getStats(UserStatus status, Date startTime);
}
