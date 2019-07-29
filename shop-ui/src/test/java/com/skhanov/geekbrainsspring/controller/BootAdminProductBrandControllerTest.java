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
 * BootAdminProductBrandControllerTest
 */
@RunWith(SpringRunner.class)
// @WebMvcTest()
@AutoConfigureMockMvc
@SpringBootTest
@WithMockUser(username = "admin", roles = { "ADMIN" })
public class BootAdminProductBrandControllerTest {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProductBrandPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/product-brands")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk()).andExpect(content().string(Matchers.containsString("Samsung")))
                .andExpect(model().attribute(PAGE_HEADER, "all product Brands"))
                .andExpect(model().attributeExists("productBrands"));
    }

    @Test
    public void testCreateProductBrand() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/product-brands/create")).andExpect(status().isOk())
                .andExpect(model().attributeExists("productBrand")).andExpect(view().name("/admin/product-brand-form"));
    }

}