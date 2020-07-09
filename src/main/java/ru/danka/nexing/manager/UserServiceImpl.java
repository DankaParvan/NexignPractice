package ru.danka.nexing.manager;

import org.springframework.stereotype.Service;
import ru.danka.nexing.exception.UnknownUserException;
import ru.danka.nexing.model.User;
import ru.danka.nexing.model.UserRepository;
import ru.danka.nexing.model.UserStatus;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UnknownUserException("Can't find user with this id"));
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
