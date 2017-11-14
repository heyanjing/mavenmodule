package com.he.spring.web.controllertpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by heyanjing on 2017/11/14 11:06.
 */
@Controller
@RequestMapping("/tpl")
public class TplController  {

    @GetMapping(value = {"","/"})
    public String index(Model model){
        model.addAttribute("a","ax");
        model.addAttribute("animalForm", new AnimalForm(1l,"a",2,"b"));
        return "/index";
    }
    @PostMapping(value = {"","/"},params = {"save"})
    public String doAdd(AnimalForm form){
        System.out.println("动物名：" + form.getOname());
        System.out.println("数量：" + form.getOcount());
        System.out.println("备注：" + form.getMemo());
        return "/index";
    }
}
