package com.he.spring.web.controller;

import com.he.maven.module.utils.Dates;
import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;


    private Integer count = 1;


    /*
      * data
     **/
    @RequestMapping("/save")
    @ResponseBody
    public Dog save() {
        Dog d = new Dog("dog" + count, count++, Dates.newDate());
        return this.dogService.save(d);
    }

    /*
     *T
     */
    @RequestMapping("/findByName")
    @ResponseBody
    public List<Dog> findByName(String name) {
        return this.dogService.findByName(name);
    }

    @RequestMapping("/pageByName")
    @ResponseBody
    public Page<Dog> pageByName(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.dogService.pageByName(name, pageNumber, pageSize);
    }

    /*
     * custom
     */
    @RequestMapping("/findByNameCustom")
    @ResponseBody
    public List<Person> findByNameCustom(String name) {
        return this.dogService.findByNameCustom(name);
    }

    @RequestMapping("/pageByNameCustom")
    @ResponseBody
    public Page<Person> pageByNameCustom(String name, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        return this.dogService.pageByNameCustom(name, pageNumber, pageSize);
    }
}
