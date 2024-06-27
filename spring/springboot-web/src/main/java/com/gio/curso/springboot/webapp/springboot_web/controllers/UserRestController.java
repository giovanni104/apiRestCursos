package com.gio.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gio.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path = "/details-map")
    public Map<String, Object> detailsMap() {

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("name", "giovanny");
        body.put("lastname", "hernandez");
        return body;
    }
    
    @GetMapping(path="/details")    
    public Map<String, Object>  details() {
        Map<String, Object> body = new HashMap<>();
        User user = new User("Andres", "Guzman");
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);

        return body;
    }
}
