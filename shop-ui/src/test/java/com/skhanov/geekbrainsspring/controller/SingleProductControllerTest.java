package com.skhanov.geekbrainsspring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * SingleProductControllerTest
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SingleProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSingleProductPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/single-product").contentType(MediaType.TEXT_HTML))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().attributeExists("product"));
    }


}