package com.he.maven.module.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by heyanjing on 2017/10/27 9:46.
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/spring-web*.xml"})
public class ControllerTest extends BaseTest {
    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void before() {
        //可以对所有的controller来进行测试
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        //仅仅对单个Controller来进行测试
        // mockMvc = MockMvcBuilders.standaloneSetup(new MeunController()).build();
    }
}
