package org.trackerwebapp.customauthdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

  public Optional<UserEntity> findByEmail(String email) {
    return Optional.of(new UserEntity(email, "password" , "source"));
  }

  public void save(UserEntity user) {
    System.out.println("User saved: " + user);
  }
}