package pers.caojiehang.blogs.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pers.caojiehang.blogs.client.models.Response;
import pers.caojiehang.blogs.common.errors.ResourceNotFoundException;

import static pers.caojiehang.blogs.client.models.Code.*;
import static pers.caojiehang.blogs.common.utils.Blank.*;

/**
 * Service 切面.
 *
 * @author linckye 2018-08-15
 */
@Aspect
@Slf4j
@Component
public class ServiceAspect {

    @Pointcut("execution(* pers.caojiehang.blogs.service.*Service*.*(..))")
    private void serverPointCut() {}

    /** Service 统一异常处理. **/
    @Around("ServiceAspect.serverPointCut()")
    @SuppressWarnings("unchecked")
    public Object handleErrors(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        // check args
        if (containsNullOrNoneElements(proceedingJoinPoint.getArgs()))
            return ((Class<? extends Response>) ((MethodSignature) proceedingJoinPoint.getSignature()).getReturnType())
                    .newInstance()
                    .setCode(ILLEGAL_ARGUMENT.getValue())
                    .setMessage("Request parameter is required");

        // handle throwable
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {

            // dispatch
            Integer code;
            if (throwable instanceof ResourceNotFoundException) code = RESOUCE_NOT_FOUND.getValue();
            else if (throwable instanceof IllegalArgumentException) code =  ILLEGAL_ARGUMENT.getValue();
            else {
                code = UNEXPECTED_ERROR.getValue();
                log.error("Unexpected error method={} args={}",
                        proceedingJoinPoint.getSignature(),
                        proceedingJoinPoint.getArgs(),
                        throwable
                );
            }
            return new Response<>().setCode(code).setMessage(throwable.getMessage());
        }
    }

}
