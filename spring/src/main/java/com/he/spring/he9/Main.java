package com.he.spring.he9;

import com.he.spring.he9.bean.Student2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heyanjing on 2017/11/18 21:07.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("he9/spring.xml");
        //region Description  spring AOP  xml 方式
        //        Student student = context.getBean("student", Student.class);
//        student.getName();
//        student.getAge();
//        student.printThrowException();
        //endregion
        //region Description Spring Aop 注解方式
        Student2 student = context.getBean("student2", Student2.class);
        student.getName();
        student.getAge();
        student.printThrowException();
        //endregion
    }
}
