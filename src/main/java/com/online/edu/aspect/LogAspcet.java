package com.online.edu.aspect;

import com.online.edu.controller.TeacherController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//切面编程对日志的处理
@Aspect
@Component
public class LogAspcet {

    public static final Logger logger=org.slf4j.LoggerFactory.getLogger(TeacherController.class);
    //创建切面的切入点
    @Pointcut("execution(* com.online.edu.controller.*.*(..))")
    public void log(){}
    //    定义在log方法执行前需要执行的内容
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String  ip = request.getRemoteAddr();
//        上面获取的ip通过localhost访问时记录为0.0.0.0.0.0.1,是因为windows内部将localhost映射为IPV6地址
//        只要改用ipv4的实际ip进行访问就会正常获取ip
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
//        将上面通过不同工具获取的信息封装到requestLog内部类中
        RequestLog requestLog = new RequestLog(url, ip,classMethod,args);
        logger.info("-------doBefore----------");
        logger.info("Request : {}",requestLog);
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
