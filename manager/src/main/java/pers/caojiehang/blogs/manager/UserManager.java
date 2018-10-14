package pers.caojiehang.blogs.manager;

import pers.caojiehang.blogs.manager.models.QueryUsers;
import pers.caojiehang.blogs.manager.models.User;

import java.util.List;

/**
 * @author linckye 2018-10-14
 */
public interface UserManager {

    List<User> queryUsers(QueryUsers queryUsers);

    void deleteUser(Long id);

    void addUser(User user);

    void updateUser(User user);

    User getUser(Long id);

}
