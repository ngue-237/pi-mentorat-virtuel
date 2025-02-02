package com.logonedigital.pi_mentorat_virtuel.service.sujet;


import com.logonedigital.pi_mentorat_virtuel.entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    User getUserById(Integer userId);
    User updatedUser(User user, Integer userId);
    void deleteUser(Integer userId);

}
