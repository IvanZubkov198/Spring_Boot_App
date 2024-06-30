package zubkov.spring.springboot.dao;

import zubkov.spring.springboot.entity.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUser(long id);

    void deleteUser(long id);
}
