package org.wsecu.techchallenge.techchallenge.initialize;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wsecu.techchallenge.techchallenge.domain.User;
import org.wsecu.techchallenge.techchallenge.repositories.UserRepository;

@Component
public class InitializeData implements CommandLineRunner {
    private final UserRepository userRepository;

    public InitializeData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading User Data");

        List<User> users = new ArrayList<User>();

        User u1 = new User();
        u1.setUsername("johndoe");
        u1.setName("John Doe");
        u1.setEmail("john.doe@wsecu.org");
        users.add(u1);

        User u2 = new User();
        u2.setUsername("janedoe");
        u2.setName("Jane Doe");
        u2.setEmail("Jane.Doe@wsecu.org");
        users.add(u2);

        User u3 = new User();
        u3.setUsername("jodoe");
        u3.setName("Jo Doe");
        u3.setEmail("Jo.Doe@wsecu.org");
        users.add(u3);

        userRepository.saveAll(users);

        System.out.println("Finished Loading User Data");

    }
}
