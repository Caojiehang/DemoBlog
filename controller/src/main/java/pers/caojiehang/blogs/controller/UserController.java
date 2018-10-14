package pers.caojiehang.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.caojiehang.blogs.client.UserService;
import pers.caojiehang.blogs.client.models.Response;
import pers.caojiehang.blogs.client.models.users.*;

/**
 * @author linckye 2018-10-14
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public Response<? extends AddUserResponse> addUser(
            @RequestBody AddUserRequest addUserRequest) {
        return userService.addUser(addUserRequest);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Response<? extends UpdateUserResponse> updateUser(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserRequest updateUserRequest) {
        updateUserRequest.getUserDescription().setId(id);
        return userService.updateUser(updateUserRequest);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Response<? extends GetUserResponse> getUser(
            @PathVariable("id") Long id) {
        return userService.getUser(new GetUserRequest().setId(id));
    }

    @GetMapping
    @ResponseBody
    public Response<? extends ListUsersResponse> listUsers(
            @RequestBody ListUsersRequest listUsersRequest) {
        return userService.listUsers(listUsersRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Response<? extends DeleteUserResponse> deleteUser(
            @PathVariable("id") Long id) {
        return userService.deleteUser(new DeleteUserRequest().setId(id));
    }

}
