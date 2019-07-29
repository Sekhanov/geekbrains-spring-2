package com.skhanov.geekbrainsspring.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestRestController
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    public static class Person {
        
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }        
    }

    @GetMapping
    public Person getPerson() {
        return new Person("Ivan", 20);
    }

}