package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.dto.CreateUser;
import com.example.demo.model.dto.UserView;
import com.example.demo.model.entity.User;
import com.example.demo.utils.UserModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserModelMapper mapper;

    public UserService(UserRepository userRepository, UserModelMapper modelMapper) {
        this.repository = userRepository;
        this.mapper = modelMapper;
    }

    public UserView getUser(String id) throws UserNotFoundException {
        return repository.findById(id)
                .map(mapper::toUserView)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
    }

    public List<UserView> getAllUsers(LocalDate date) {
        if (date != null) {
            return repository.findAllByDate(date)
                    .stream()
                    .map(mapper::toUserView)
                    .toList();
        }
        return repository.findAll()
                .stream()
                .map(mapper::toUserView)
                .toList();
    }

    @Modifying
    public void saveUser(CreateUser dto) {
        User user = mapper.toUser(dto);
        user.setDate(LocalDate.now());
        repository.save(user);
    }

    public void deleteUser(String id) throws UserNotFoundException {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exist"));
        repository.delete(user);
    }
}
