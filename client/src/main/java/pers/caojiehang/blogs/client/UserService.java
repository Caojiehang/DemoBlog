package pers.caojiehang.blogs.client;

import pers.caojiehang.blogs.client.models.*;
import pers.caojiehang.blogs.client.models.users.*;

/**
 * @author linckye 2018-10-14
 */
public interface UserService {

    Response<? extends AddUserResponse> addUser(AddUserRequest addUserRequest);

    Response<? extends UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest);

    Response<? extends GetUserResponse> getUser(GetUserRequest getUserRequest);

    Response<? extends DeleteUserResponse> deleteUser(DeleteUserRequest deleteUserRequest);

    Response<? extends QueryUsersResponse> queryUsers(QueryUsersRequest queryUsersRequest);

}
