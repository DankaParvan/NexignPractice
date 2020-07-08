package ru.danka.nexing.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danka.nexing.model.User;
import ru.danka.nexing.model.UserStatus;
import ru.danka.nexing.model.UserRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    UserRepository userRepository;


    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Long createUser(String username, String email) {
        return userRepository.save(new User(null, username, email, UserStatus.UNKNOWN, new Date(0))).getId();
    }

    @Override
    public UserStatus updateStatus(Long id, UserStatus status) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            User user = userById.get();
            UserStatus previous = user.getStatus();
            user.setStatus(status);
            user.setLastChangeDate(new Date());
            userRepository.save(user);
            return status;
        } else {
            throw new IllegalStateException("Unknown user.");
        }
    }
}
