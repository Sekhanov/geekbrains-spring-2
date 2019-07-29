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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * BootAdminProductColorControllerTest
 */
@RunWith(SpringRunner.class)
// @WebMvcTest()
@AutoConfigureMockMvc
@SpringBootTest
@WithMockUser(username = "admin", roles = { "ADMIN" })
public class BootAdminProductColorControllerTest {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProductColorPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/product-colors")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk()).andExpect(content().string(Matchers.containsString("black")))
                .andExpect(model().attribute(PAGE_HEADER, "all product Colors"))
                .andExpect(model().attributeExists("productColors"));
    }

    @Test
    public void testCreateProductColor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/product-colors/create")).andExpect(status().isOk())
                .andExpect(model().attributeExists("productColor")).andExpect(view().name("/admin/product-color-form"));
    }

}