package com.skhanov.geekbrainsspring.controller.rest;

import static org.junit.Assert.assertEquals;

import com.skhanov.geekbrainsspring.controller.rest.DemoRestController.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DemoRestControllerTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoRestControllerTest {
        
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    public void testRestController() {
        ResponseEntity<Person> responseEntity =  testRestTemplate.getForEntity(String.format("http://localhost:%d/rest", port), Person.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Ivan", responseEntity.getBody().getName());

    }
}