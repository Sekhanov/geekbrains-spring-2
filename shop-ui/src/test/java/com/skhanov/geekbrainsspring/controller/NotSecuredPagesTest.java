package com.skhanov.geekbrainsspring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * NotSecuredPagesTest
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class NotSecuredPagesTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/index"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    
    @Test
    public void testProductCategory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/category"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testContacts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contact"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}