package com.gstu.service;

import com.gstu.entity.Role;
import com.gstu.entity.User;
import com.gstu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(Long idUser) {
        repository.deleteById(idUser);
    }

    public boolean saveUser(User user) {
        // Проверка существует ли такой пользователь
        if (repository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        // Установка для пользователя обычную роль
        user.setRole(Role.USER);
        repository.save(user);
        return true;
    }
}
