package pers.caojiehang.blogs.client.models.users;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linckye 2018-10-14
 */
@Data
@Accessors(chain = true)
public class AddUserRequest {

    private UserDescription userDescription;

}
