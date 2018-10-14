package pers.caojiehang.blogs.manager;

import pers.caojiehang.blogs.manager.models.QueryUser;
import pers.caojiehang.blogs.manager.models.User;

import java.util.List;

/**
 * @author linckye 2018-10-14
 */
public interface UserManager {

    List<User> queryUser(QueryUser queryUser);

    void deleteUser(Long id);

    void addUser(User user);

    void updateUser(User user);

}
