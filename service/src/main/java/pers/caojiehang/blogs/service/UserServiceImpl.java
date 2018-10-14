package pers.caojiehang.blogs.service;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.caojiehang.blogs.client.UserService;
import pers.caojiehang.blogs.client.models.Response;
import pers.caojiehang.blogs.client.models.users.*;
import pers.caojiehang.blogs.manager.UserManager;
import pers.caojiehang.blogs.manager.models.QueryUsers;
import pers.caojiehang.blogs.manager.models.User;

import java.util.ArrayList;
import java.util.List;

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
    private Converter<QueryUsersRequest, QueryUsers> queryUsersConverter;

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
        return Response.success(new AddUserResponse());
    }

    @Override
    public Response<? extends UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest) {
        // check args
        UserDescription userDescription = updateUserRequest.getUserDescription();
        if (isNull(userDescription)) return new Response<UpdateUserResponse>()
                .setCode(ILLEGAL_ARGUMENT.getValue())
                .setMessage("UserDescription is required");
        userManager.updateUser(userConverter.convert(userDescription));
        return Response.success(new UpdateUserResponse());
    }

    @Override
    public Response<? extends GetUserResponse> getUser(GetUserRequest getUserRequest) {
        UserDescription userDescription = userConverter.reverse().convert(
                userManager.getUser(getUserRequest.getId())
        ).setPassword(null);
        return Response.success(new GetUserResponse()
                .setUserDescription(userDescription)
        );
    }

    @Override
    public Response<? extends DeleteUserResponse> deleteUser(DeleteUserRequest deleteUserRequest) {
        userManager.deleteUser(deleteUserRequest.getId());
        return Response.success(new DeleteUserResponse());
    }

    @Override
    public Response<? extends QueryUsersResponse> queryUsers(QueryUsersRequest queryUsersRequest) {
        List<UserDescription> userDescriptions = Lists.newArrayList(
                userConverter.reverse().convertAll(
                        userManager.queryUsers(queryUsersConverter.convert(queryUsersRequest))
                )
        );
        userDescriptions.forEach(userDescription -> userDescription.setPassword(null));
        return Response.success(new QueryUsersResponse()
                .setUserDescriptions(userDescriptions)
        );
    }

}
