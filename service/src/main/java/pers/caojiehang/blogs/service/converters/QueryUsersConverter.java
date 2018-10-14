package pers.caojiehang.blogs.service.converters;

import com.google.common.base.Converter;
import org.springframework.stereotype.Component;
import pers.caojiehang.blogs.client.models.users.QueryUsersRequest;
import pers.caojiehang.blogs.manager.models.QueryUsers;

/**
 * @author linckye 2018-10-14
 */
@Component
public class QueryUsersConverter extends Converter<QueryUsersRequest, QueryUsers> {
    @Override
    protected QueryUsers doForward(QueryUsersRequest queryUsersRequest) {
        return new QueryUsers();
    }

    @Override
    protected QueryUsersRequest doBackward(QueryUsers queryUsers) {
        return new QueryUsersRequest();
    }
}
