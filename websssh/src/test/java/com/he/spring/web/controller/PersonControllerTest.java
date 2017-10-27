package com.he.spring.web.controller;

import com.he.maven.module.test.ControllerTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by heyanjing on 2017/10/27 9:50.
 */
public class PersonControllerTest extends ControllerTest {

    private static final Logger log = LoggerFactory.getLogger(PersonControllerTest.class);


    @Test
    public void findAllxSql() throws Exception {
        ResultActions actions = super.mockMvc.perform(get("/person/findAllxSql"));
        System.out.println(status());//
        actions.andExpect(status().isOk());
    }
}