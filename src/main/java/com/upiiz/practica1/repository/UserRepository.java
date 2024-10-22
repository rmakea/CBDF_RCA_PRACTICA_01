package com.upiiz.practica1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.upiiz.practica1.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    public User save(User user) {
        user.setId(id.incrementAndGet());
        users.add(user);
        return user;
    }

    public List<User> findAllByClassId(Long classId) {
        return users.stream().filter(user -> user.getClassId().equals(classId)).collect(Collectors.toList());
    }

    public User findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User update(User user) {
        delete(user.getId());
        users.add(user);
        return user;
    }
}
