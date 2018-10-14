package pers.caojiehang.blogs.service;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.caojiehang.blogs.client.UserService;
import pers.caojiehang.blogs.client.models.Response;
import pers.caojiehang.blogs.client.models.users.*;
import pers.caojiehang.blogs.manager.UserManager;
import pers.caojiehang.blogs.manager.models.QueryUser;
import pers.caojiehang.blogs.manager.models.User;

import static pers.caojiehang.blogs.common.utils.Blank.*;
import static pers.caojiehang.blogs.client.models.Code.*;

/**
 * @author linckye 2018-10-14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Converter<UserDescription, User> userConverter;

    @Autowired
    private UserManager userManager;

    @Override
    public Response<? extends AddUserResponse> addUser(AddUserRequest addUserRequest) {
        // check args
        UserDescription userDescription = addUserRequest.getUserDescription();
        if (isNull(userDescription)) return new Response<AddUserResponse>()
                .setCode(ILLEGAL_ARGUMENT.getValue())
                .setMessage("UserDescription is required");
        userManager.addUser(userConverter.convert(userDescription));
        return Response.success();
    }

    @Override
    public Response<? extends UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest) {
        // check args
        UserDescription userDescription = updateUserRequest.getUserDescription();
        if (isNull(userDescription)) return new Response<UpdateUserResponse>()
                .setCode(ILLEGAL_ARGUMENT.getValue())
                .setMessage("UserDescription is required");
        userManager.updateUser(userConverter.convert(userDescription));
        return Response.success();
    }

    @Override
    public Response<? extends GetUserResponse> getUser(GetUserRequest getUserRequest) {
        return Response.success(new GetUserResponse()
                .setUserDescription(userConverter.reverse().convert(
                        userManager.getUser(getUserRequest.getId())
                        )
                )
        );
    }

    @Override
    public Response<? extends DeleteUserResponse> deleteUser(DeleteUserRequest deleteUserRequest) {
        userManager.deleteUser(deleteUserRequest.getId());
        return Response.success();
    }

    @Override
    public Response<? extends QueryUsersResponse> queryUsers(QueryUsersRequest queryUsersRequest) {
        return Response.success(new QueryUsersResponse()
                .setUserDescriptions(Lists.newArrayList(
                        userConverter.reverse().convertAll(userManager.queryUser(new QueryUser()))
                        )
                )
        );
    }

}
