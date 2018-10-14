package pers.caojiehang.blogs.controller.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.caojiehang.blogs.client.models.Response;

import javax.servlet.http.HttpServletRequest;

import static pers.caojiehang.blogs.client.models.Code.*;

/**
 * @author linckye 2018-10-08
 */
@ControllerAdvice
@Slf4j
public class ControllerErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleErrors(HttpServletRequest request, Exception e) {
        log.error("Unexpected error uri={} method={} ",
            request.getRequestURI(),
            request.getMethod()
        );
        return new Response()
                .setCode(UNEXPECTED_ERROR.getValue())
                .setMessage(e.getMessage());
    }

}
