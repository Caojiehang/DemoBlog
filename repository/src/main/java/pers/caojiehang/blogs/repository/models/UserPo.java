package pers.caojiehang.blogs.repository.models;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linckye 2018-10-14
 */
@Data
@Accessors(chain = true)
public class UserPo {

    private Long id;

    private String username;

    private String password;

}
