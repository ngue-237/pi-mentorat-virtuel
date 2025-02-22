package com.logonedigital.pi_mentorat_virtuel.services.suje;

import com.logonedigital.pi_mentorat_virtuel.entities.User;
import com.logonedigital.pi_mentorat_virtuel.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;


    public UserServiceImpl(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return this.userRepo.findById(userId).get();
    }

    @Override
    public User updatedUser(User user, Integer userId) {
        User userToEdit = this.userRepo.findById(userId).get();
        userToEdit.setFirstname(user.getFirstname());
        userToEdit.setLastname(user.getLastname());
        userToEdit.setEmail(user.getEmail());
        userToEdit.setRole(user.getRole());
        userToEdit.setPhone(user.getPhone());

        return this.userRepo.saveAndFlush(userToEdit);
    }

    @Override
    public void deleteUser(Integer userId) {
        this.userRepo.deleteById(userId);

    }
}
