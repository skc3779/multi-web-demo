package com.web.controllers.api;

import com.web.configs.ControllerConfiguration;
import com.web.configs.DomainConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DomainConfiguration.class, ControllerConfiguration.class})
@WebAppConfiguration
public class BookApiControllerTest {


    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mvc = webAppContextSetup(this.context).build();
    }

    @Test
    public void testList() throws Exception {
        mvc.perform(get("/api/book/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testRead() throws Exception {
        mvc.perform(get("/api/book/"+"1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}