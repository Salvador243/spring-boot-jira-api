package com.jira.jiraApi.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jira.jiraApi.Models.User;
import com.jira.jiraApi.Repositories.UserRepository;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> obtenerUsuario() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User guardarUsuario(User usuario) {
        return userRepository.save(usuario);
    }

    public User login(String correo, String contrasena) {
        User user = userRepository.findByCorreoElectronico(correo);
        if (user != null) {
            if (contrasena.equals(user.getcontrasena())) {
                return user;
            }

        }
        return null;
    }
}
