package com.gao.aop;

import com.gao.utils.AJaxModel;
import com.gao.utils.BaseForm;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
public class AJsonAspect {
    private static final Logger log = LoggerFactory.getLogger(AJsonAspect.class);

    @Around("execution(* com.gao.service.*.*(..))")
    public AJaxModel piontCut(ProceedingJoinPoint joinPoint) {
        HttpServletResponse response = null;
        HttpServletRequest request = null;
        BaseForm baseForm = null;
        Signature signature = (MethodSignature) joinPoint.getSignature();
        Method method = ((MethodSignature) signature).getMethod();
//        類名
        String s = method.getDeclaringClass().toString();
        log.info("切點所經過的類：" + s);
        String name = method.getName();
        log.info("切點所經過的方法名：" + name);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseForm) {
                baseForm = (BaseForm) arg;
            } else if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
            }
        }
        try {
            baseForm.parseObjectToMap();
            return (AJaxModel) joinPoint.proceed();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
