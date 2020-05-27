package com.challenge.service.implementation;

import com.challenge.entity.User;
import com.challenge.repository.UserServiceRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplemetation implements UserServiceInterface {

    @Autowired
    private UserServiceRepository userServiceRepository;

    @Override
    public Optional<User> findById(Long userId) {
        return userServiceRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return this.userServiceRepository.findByAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return this.userServiceRepository.findByCompanyId(companyId);
    }

    @Override
    public User save(User object) {
        object.setCreatedAt(LocalDateTime.now());
        return this.userServiceRepository.save(object);
    }
}
