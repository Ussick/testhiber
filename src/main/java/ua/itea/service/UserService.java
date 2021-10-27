package ua.itea.service;

import ua.itea.component.UserEntityManager;
import ua.itea.component.UserMapper;
import ua.itea.dto.UserDto;
import ua.itea.model.UserEntity;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {
    private final UserEntityManager userEm;
    private final UserMapper userMapper;

    public UserService(UserEntityManager userEm, UserMapper userMapper) {
        this.userEm = userEm;
        this.userMapper = userMapper;
    }

    public UserDto getUserById(int id) {
        return userMapper.entityToDto(userEm.getUserById(1));
    }

    public UserDto addUser(UserEntity user){
        user.setPassword(getSaltedHashedPassword(user.getPassword()));
        return userMapper.entityToDto(userEm.insertUser(user));
    }

    private String getSaltedHashedPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String passphrase = "myspecialspice" + password;
        md.update(passphrase.getBytes(StandardCharsets.UTF_8));
        return String.format("%064x", new BigInteger(1, md.digest()));
    }

    public String checkLogin(String login, String password){
        return userEm.getUserByLogin(login, getSaltedHashedPassword(password));
    }
}
