package ru.danka.nexing.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danka.nexing.model.User;
import ru.danka.nexing.model.UserRepository;
import ru.danka.nexing.model.UserStatus;

import java.util.Date;
import java.util.List;

@Service
public class MiscServiceImpl implements MiscService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getStats(UserStatus status, Date startTime) {
        return userRepository.findUserByStatusEqualsAndLastChangeDateAfter(status,
                startTime == null ? new Date(0) : startTime);
    }
}
