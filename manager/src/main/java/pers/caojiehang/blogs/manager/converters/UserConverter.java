package pers.caojiehang.blogs.manager.converters;

import com.google.common.base.Converter;
import org.springframework.stereotype.Component;
import pers.caojiehang.blogs.manager.models.User;
import pers.caojiehang.blogs.repository.models.UserPo;

/**
 * @author linckye 2018-10-14
 */
@Component
public class UserConverter extends Converter<UserPo, User> {

    @Override
    protected User doForward(UserPo userPo) {
        return new User()
                .setId(userPo.getId())
                .setUsername(userPo.getUsername())
                .setPassword(userPo.getPassword());
    }

    @Override
    protected UserPo doBackward(User user) {
        return new UserPo()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());
    }

}
