package com.altman.demo.annotation;

import java.lang.reflect.Method;

public class Admin {

    @Login(username = "admin", password = "my_passwd")
    public void work() {
        System.out.println("Admin start working");
    }

    public static void main(String[] args) throws Exception {
        Admin admin = new Admin();
        // 获取 work() 方法的Method实例
        Method workMethod = admin.getClass().getMethod("work");
        checkAnnotations(workMethod);
        // 通过反射执行该方法
        workMethod.invoke(admin);
    }

    public static void checkAnnotations(Method method) {
        // 判断方法是否包含Login注解
        if (method.isAnnotationPresent(Login.class)) {
            // 获取该方法的MyAnnotation注解实例
            Login login = method.getAnnotation(Login.class);
            // 获取 login的属性值，并打印出来
            String username = login.username();
            String password = login.password();
            System.out.println(username + " login with password: " + password);
        }
    }
}
