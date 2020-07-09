package ru.danbka.helloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.danka.nexing.exception.UnknownUserException;
import ru.danka.nexing.manager.UserService;
import ru.danka.nexing.manager.UserServiceImpl;
import ru.danka.nexing.model.User;
import ru.danka.nexing.model.UserRepository;
import ru.danka.nexing.model.UserStatus;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void inMemoryImplementationTest() {
        userService.createUser("hi", "hi");
        try {
            userService.getUser(1L);
        } catch (UnknownUserException e) {
            Assertions.fail();
        }
        userService.updateStatus(1L, UserStatus.OFFLINE);
        Assertions.assertTrue(userService.getUser(1L).getStatus() == UserStatus.OFFLINE, "status not changed");
    }


    @Test
    public void getTest() {
        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserServiceImpl(repository);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        Mockito.when(repository.findById(0L)).thenReturn(Optional.of(Mockito.mock(User.class)));

        Assertions.assertNotNull(service.getUser(0L));
        try {
            service.getUser(1L);
            Assertions.fail();
        } catch (UnknownUserException e) {

        }
    }

    @Test
    public void registerTest() {
        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserServiceImpl(repository);
        long id = ThreadLocalRandom.current().nextLong();
        String randomName = UUID.randomUUID().toString().replaceAll("-", "");
        Mockito.when(repository.save(Mockito.any())).thenReturn(new User(id, null, null, null, null));
        Assertions.assertEquals(service.createUser(randomName, randomName + "@hi.ru"), id);
    }
}
