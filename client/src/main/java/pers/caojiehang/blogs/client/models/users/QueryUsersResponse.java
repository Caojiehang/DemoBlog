package pers.caojiehang.blogs.client.models.users;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author linckye 2018-10-14
 */
@Data
@Accessors(chain = true)
public class QueryUsersResponse {

    private List<UserDescription> userDescriptions;

}
