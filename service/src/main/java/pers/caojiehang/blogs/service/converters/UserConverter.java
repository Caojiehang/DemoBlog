package pers.caojiehang.blogs.service.converters;

import com.google.common.base.Converter;
import org.springframework.stereotype.Component;
import pers.caojiehang.blogs.client.models.users.UserDescription;
import pers.caojiehang.blogs.manager.models.User;

/**
 * @author linckye 2018-10-14
 */
@Component
public class UserConverter extends Converter<UserDescription, User> {

    @Override
    protected User doForward(UserDescription userDescription) {
        return new User()
                .setId(userDescription.getId())
                .setUsername(userDescription.getUsername())
                .setPassword(userDescription.getPassword());
    }

    @Override
    protected UserDescription doBackward(User user) {
        return new UserDescription()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());
    }

}
