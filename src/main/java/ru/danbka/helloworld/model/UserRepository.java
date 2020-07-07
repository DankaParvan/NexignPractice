package ru.danbka.helloworld.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByStatusEqualsAndLastChangeDateAfter(UserStatus status, Date lastChangeDate);
}
