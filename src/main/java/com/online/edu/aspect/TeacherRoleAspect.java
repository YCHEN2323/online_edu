package com.online.edu.aspect;

import com.online.edu.service.RedisService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

//切面编程测试对teacher功能的日志处理
@Aspect
@Component
public class FliterAspcet {
    public static final Logger logger=LoggerFactory.getLogger(LogAspcet.class);
    //创建切面的切入点
    @Pointcut("execution(* com.online.edu.controller.TeacherController.*(..))")
    public void log(){}
    //    定义在log方法执行前需要执行的内容
    @Before("log()")
    public void doBefore(){

    }

    //    定义在log方法执行后要执行的方法
    @After("log()")
    public void doAfter(){
        logger.info("-------doAfter----------");
    }
    //    拦截返回的内容为result结果
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterRunturn(Object result){
        logger.info("Result : {}" +result);
    }
    //定义log实体类来接收对应的数据
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
        //        定义一个内部类进行返回信息的封装
        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}

