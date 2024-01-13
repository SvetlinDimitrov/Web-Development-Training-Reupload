package org.example.runables;

import org.example.UserRepository;
import org.example.models.UserEntity;

import java.util.concurrent.Callable;

public class UserThread implements Callable<Integer> {
    public final UserRepository userRepository = new UserRepository();
    public final String userInputLine;

    public UserThread(String userInputLine) {
        this.userInputLine = userInputLine;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " processing");
        UserEntity userEntity = new UserEntity();
        userEntity.setGmail(userInputLine.split(",")[0]);
        userEntity.setNumber(Integer.parseInt(userInputLine.split(",")[2]));
        userEntity.setUsername(userInputLine.split(",")[1]);

        userRepository.save(userEntity);
        return 1;
    }
}
