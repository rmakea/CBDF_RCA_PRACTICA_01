package com.upiiz.practica1.service;

import com.upiiz.practica1.models.User;
import com.upiiz.practica1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllByClassId(Long classId) {
        return userRepository.findAllByClassId(classId);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}
