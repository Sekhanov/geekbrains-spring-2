package com.skhanov.geekbrainsspring.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * BootAdminProductBrandControllerTest
 */
@RunWith(SpringRunner.class)
// @WebMvcTest()
@AutoConfigureMockMvc
@SpringBootTest
@WithMockUser(username = "admin", roles = {"ADMIN"})
public class BootAdminProductBrandControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testProductBrandPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/product-brands"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())   
        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Samsung")));
    }
    
}