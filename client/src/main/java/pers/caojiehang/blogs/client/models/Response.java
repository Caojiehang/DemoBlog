package pers.caojiehang.blogs.client.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static pers.caojiehang.blogs.common.utils.Blank.*;
import static pers.caojiehang.blogs.client.models.Code.*;

/**
 * @author linckye 2018-10-08
 */
@ToString
@Accessors(chain = true)
public class Response<D> {

    @Getter@Setter
    private D data;

    @Getter@Setter
    private String message;

    @Getter@Setter
    private Integer code;

    private static final Response SUCCESS_RESPONSE = success(null);

    public static <D> Response<D> success() {
        return SUCCESS_RESPONSE;
    }

    public static <D> Response<D> success(D data) {
        Response<D> response = new Response<>();
        response.code = SUCCESS.getValue();
        response.message = "Success";
        response.data = data;
        return response;
    }

}
