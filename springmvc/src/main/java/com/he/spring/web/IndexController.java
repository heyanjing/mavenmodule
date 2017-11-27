package com.he.spring.web;

import com.he.spring.bean.User;
import com.he.spring.bean.User2;
import com.he.spring.bean.UserCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

/**
 * Created by heyanjing on 2017/11/23 10:40.
 */
@Controller
@RequestMapping("/index")
@SessionAttributes(value = {"a","b","user","user3","user2","usercopy"})//// MEINFO:2017/11/27 9:09 SessionAttributes申明了的值， 标注在方法上的@ModelAttribute会存入session， Model 存入的属性会存入到session
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);


    @GetMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("b","bx");
        model.addAttribute("a","ax");
        model.addAttribute("user3",new User("何彦静x", 32, new Date()));
        return "/index";
    }
    @GetMapping("/helloWorld2")
    public String helloWorld2() {
        return "/index";
    }

    /**
     * 两个请求返回的结果不相同
     * http://localhost:8080/index/modelAttribute?name=何彦静&age=28&birthday=1989-09-19
     * http://localhost:8080/index/modelAttribute
     *
     * @param user     @ModelAttribute("user") User user 封装请求参数为User对象，并暴露为模型数据用于视图页面展示时使用
     *                 （因为UserCopy的属性与User相同，也封装了请求参数为UserCopy对象，从而导致了getUserCopy方法参数的对象被覆盖了）
     * @param user2    @ModelAttribute("user2") User user2 引用getUser方法产生的user2，并暴露为模型数据用于视图页面展示时使用
     * @param usercopy @ModelAttribute("usercopy") UserCopy getUserCopy 引用getUserCopy方法产生的usercopy，并暴露为模型数据用于视图页面展示时使用
     *                 当请求参数中
     */
    @GetMapping("/modelAttribute")
    public String modelAttribute(@ModelAttribute("user") User user, @ModelAttribute("user2") User2 user2, @ModelAttribute("usercopy") UserCopy usercopy, Model model) {
        log.info("{}", user);
        log.info("{}", user2);
        log.info("{}", usercopy);
        model.addAttribute("a","草泥马");
        return "/index";
    }

    @ModelAttribute("user2")
    public User2 getUser2() {
        return new User2("何彦静x", 29, new Date());
    }

    @ModelAttribute("usercopy")
    public UserCopy getUserCopy() {
        return new UserCopy("何彦静x", 30, new Date());
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User("何彦静x", 31, new Date());
    }


}
