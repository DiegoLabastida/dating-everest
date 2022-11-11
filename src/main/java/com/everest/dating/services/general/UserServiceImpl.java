package com.everest.dating.services.general;

import com.everest.dating.models.entity.User;
import com.everest.dating.models.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class UserServiceImpl implements ServiceGeneral<User> {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        try {
            if (!userRepository.findById(user.getId()).isEmpty())
                throw new SQLIntegrityConstraintViolationException("User Already Exists ID: " + user.getId());
            return userRepository.save(user);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {

    }

}
