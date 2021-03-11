package com.zup.apitestedesenvolvedor3.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    static final Long ID = 1L;
    static final String URL = "/api/v1/products";

    @Autowired
    public WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testRequisicionIdSucess() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL))
                .andExpect(status().isOk());

    }

    @Test
    public void testRequisicionIdError() throws Exception {
        String url = URL + "/20";
        this.mvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isNotFound());
    }

}
