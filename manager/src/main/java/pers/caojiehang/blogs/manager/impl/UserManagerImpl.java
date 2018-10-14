package pers.caojiehang.blogs.manager.impl;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.caojiehang.blogs.common.errors.ResourceNotFoundException;
import pers.caojiehang.blogs.manager.UserManager;
import pers.caojiehang.blogs.manager.models.QueryUser;
import pers.caojiehang.blogs.manager.models.User;
import pers.caojiehang.blogs.repository.UserRepository;
import pers.caojiehang.blogs.repository.models.UserPo;

import java.util.List;

import static pers.caojiehang.blogs.common.utils.Blank.*;

/**
 * @author linckye 2018-10-14
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Converter<UserPo, User> userConverter;

    @Override
    public List<User> queryUser(QueryUser queryUser) {
        // check args
        if (isNull(queryUser)) throw new IllegalArgumentException("QueryUser is required");
        List<UserPo> userPos = userRepository.selectUsers();
        return Lists.newArrayList(userConverter.convertAll(userPos));
    }

    @Override
    public void deleteUser(Long id) {
        if (isNull(id)) throw new IllegalArgumentException("User id is required");
        if (userRepository.deleteUser(id) == 0) throw new ResourceNotFoundException("User[id=" + id + "] not found");
    }

    @Override
    public void addUser(User user) {
        if (isNull(user)) throw new IllegalArgumentException("User is required");
        UserPo userPo = userConverter.reverse().convert(user);
        if (userRepository.insertUser(userPo) == 0) {
            // TODO
            throw new IllegalStateException("Insert failed");
        }
    }

    @Override
    public void updateUser(User user) {
        if (isNull(user)) throw new IllegalArgumentException("User is required");
        UserPo userPo = userConverter.reverse().convert(user);
        if (userRepository.updateUser(userPo) == 0) {
            throw new ResourceNotFoundException("User[id=" + userPo.getId() + "] not found");
        }
    }

    @Override
    public User getUser(Long id) {
        if (isNull(id)) throw new IllegalArgumentException("User id is required");
        UserPo userPo = userRepository.selectUser(id);
        if (isNull(userPo)) throw new ResourceNotFoundException("User[id=" + id + "] not found");
        return userConverter.convert(userPo);
    }

}
