package org.zerock.ex3.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {


    @Autowired
    private MockMvc mvc;

    @DisplayName("hello가 리턴된다")
    @Test
    public void hello() throws Exception {

        String name = "hello";
                int amount = 1000;
                mvc.perform(get("/hello/dto").param("name", name)
                        .param("amount", String.valueOf(amount)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name",is(name)))
                        .andExpect(jsonPath("$.amount", is(amount)));
    }
}
