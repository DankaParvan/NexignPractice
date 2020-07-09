package ru.danka.nexing.manager;

import ru.danka.nexing.model.User;
import ru.danka.nexing.model.UserStatus;

public interface UserService {
    User getUser(Long id);

    Long createUser(String username, String email);


    /**
     * return new status.
     */
    UserStatus updateStatus(Long id, UserStatus status);
}
