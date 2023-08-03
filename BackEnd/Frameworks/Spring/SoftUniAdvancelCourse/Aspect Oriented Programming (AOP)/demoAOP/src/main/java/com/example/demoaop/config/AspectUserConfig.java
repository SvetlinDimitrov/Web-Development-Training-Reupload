package com.example.demoaop.config;

import com.example.demoaop.entity.User;
import com.example.demoaop.repo.UserRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
public class AspectUserConfig {
    private final UserRepository repo;

    public AspectUserConfig(UserRepository repo) {
        this.repo = repo;
    }

    @Pointcut("execution(* com.example.demoaop.UserServiceImp.login(..)) && args(user)")
    public void loginMethod(User user) {}

    @Pointcut("execution(* com.example.demoaop.UserServiceImp.*(..)) && args(user)")
    public void allMethods(User user) {}

    @Pointcut("execution(* com.example.demoaop.UserServiceImp.registerUser(..))")
    public void registerMethod() {}

    @Around(value = "loginMethod(user)", argNames = "point,user")
    @Order(2)
    public User loginLogic(ProceedingJoinPoint point , User user) throws Throwable {
        User userToLogin = repo.findUserByName(user.getName());

        if (userToLogin == null || !userToLogin.getPassword().equals(user.getPassword())) {
            System.out.println("No User Found");
            return null;
        }

        point.proceed(new Object[]{user});

        return userToLogin;
    }

    @Around(value = "allMethods(user)", argNames = "point,user")
    @Order(1)
    public User filterTheUser(ProceedingJoinPoint point, User user) throws Throwable {
        if (user.getName().isBlank() || user.getPassword().isBlank()) {
            System.out.println("pass or username not valid");
            return null;
        }
        point.proceed();
        return user;
    }

    @AfterReturning(value = "registerMethod()", returning  = "returnValue")
    public void saveUser(User returnValue){
        System.out.println("Register user "+ returnValue.getName());
        repo.save(returnValue);
    }

}
