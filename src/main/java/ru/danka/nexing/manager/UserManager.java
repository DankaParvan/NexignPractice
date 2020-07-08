package ru.danka.nexing.manager;

import ru.danka.nexing.model.UserStatus;
import ru.danka.nexing.model.User;

import java.util.Optional;

public interface UserManager {
    Optional<User> getUser(Long id);

    Long createUser(String username, String email);


    /**
     * return new status.
     */
    UserStatus updateStatus(Long id, UserStatus status);
}
