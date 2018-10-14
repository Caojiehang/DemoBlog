package pers.caojiehang.blogs.client.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

import static pers.caojiehang.blogs.common.utils.Blank.*;

/**
 * 响应码.
 *
 * @author linckye 2018-10-08
 */
@Getter
@AllArgsConstructor
public enum Code {

    /** 成功. **/
    SUCCESS(0),

    /** 未考虑到的异常. **/
    UNEXPECTED_ERROR(-1),

    /** 参数非法. **/
    ILLEGAL_ARGUMENT(1),

    /** 资源未找到. **/
    RESOUCE_NOT_FOUND(2)

    ;

    private Integer value;

    public static Optional<Code> from(Integer value) {
        if (isNull(value)) throw new IllegalArgumentException("Code is required");
        for (Code code : values()) {
            if (code.getValue().equals(value)) return Optional.of(code);
        }
        return Optional.empty();
    }

}
