package com.he.spring.web.controller;

import com.he.maven.module.utils.Jsons;
import com.he.spring.bean.UserBean;
import com.he.spring.web.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 *
 * 测试springMVC 常用的的请求注解
 */
@Controller
@RequestMapping("/annotation")
public class AnnotationController {
    private static final Logger log = LoggerFactory.getLogger(AnnotationController.class);

    @Autowired
    private PersonService personService;

    /**
     * 单个参数可以不使用注解，但形参名称必须与参数名称相同
     * 多个同名参数必须使用RequestParam注解
     * http://localhost:8080/spring/annotation/testRequestParam?userName=何彦静&password=密码&hobby=A&hobby=B
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "userName",defaultValue = "userName") String userName, String password, @RequestParam(value = "hobby" ,defaultValue = "a,b") List<String> hobby, UserBean user) {

        log.info(userName);//何彦静
        log.info(password);//密码
        log.info("{}", hobby);// [A, B]
        log.info(Jsons.toJson(user));
        return "/test/test";
    }

    /**
     * 必须使用该注解PathVariable
     * http://localhost:8080/spring/annotation/testPathVariable/heyanjing/mima
     */
    @RequestMapping("/testPathVariable/{userName}/{password}")
    @ResponseBody
    public Object testPathVariable(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        log.info(userName);//heyanjing
        log.info(password);//mima
        return null;
    }

    /**
     * 必须使用该注解CookieValue
     * http://localhost:8080/spring/annotation/testCookieValue
     */
    @RequestMapping("/testCookieValue")
    @ResponseBody
    public Object testCookieValue(@CookieValue("JSESSIONID") String sessionId, @CookieValue(value = "JSESSIONID", defaultValue = "") Cookie cookie) {
        log.info(sessionId);// E034110E2B75C3641AE03533A0968373
        log.info(Jsons.toJson(cookie));// {"name":"JSESSIONID","value":"E034110E2B75C3641AE03533A0968373","version":0,"comment":null,"domain":null,"maxAge":-1,"path":null,"secure":false,"httpOnly":false}
        return null;
    }

    /**
     * 必须使用该注解RequestHeader
     * http://localhost:8080/spring/annotation/testRequestHeader
     */
    @RequestMapping("/testRequestHeader")
    @ResponseBody
    public Object testRequestHeader(@RequestHeader("User-Agent") String userAgent, @RequestHeader(value = "Accept") String accepts, @RequestHeader(value = "Accept") List<String> acceptsList) {
        log.info(userAgent);// Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36
        log.info(accepts);//text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
        log.info(Jsons.toJson(acceptsList));// ["text/html","application/xhtml+xml","application/xml;q=0.9","image/webp","image/apng","*/*;q=0.8"]
        return null;
    }

    /**
     * 必须使用该注解ModelAttribute
     * 绑定请求参数到返回的视图
     * <p>
     * http://localhost:8080/spring/annotation/testModelAttribute1?userName=何彦静&password=密码
     */
    @RequestMapping("/testModelAttribute1")
    public String testModelAttribute1(@ModelAttribute("user") UserBean user) {
        log.warn("modelAttribute");
        log.info(Jsons.toJson(user));
        return "/test/test";
    }


    /**
     * 必须使用该注解RequestHeader
     * http://localhost:8080/spring/annotation/testModelAttribute2
     * http://localhost:8080/spring/annotation/testModelAttribute2?userName=何彦静&password=密码
     *
     * 当@ModelAttribute("user") UserBean user的属性名与getUser方法的属性相同时,视图页面使用的是@ModelAttribute("user") UserBean user
     */
    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("user") UserBean user) {
        log.warn("testModelAttribute2");
        log.info(Jsons.toJson(user));
        return "/test/test";
    }

    /**
     * 该方法会在该controller的所有RequestMapping方法之前执行,也可以像RequestMapping方法一样封装数据
     */
    @ModelAttribute("userx")
    public UserBean getUser(UserBean userBean) {
        log.warn("getUser");
        log.info(Jsons.toJson(userBean));
        userBean = new UserBean("名字", "密码");
        log.info(Jsons.toJson(userBean));
        return userBean;
    }

}
