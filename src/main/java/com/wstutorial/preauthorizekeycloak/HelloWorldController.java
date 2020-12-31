package com.wstutorial.preauthorizekeycloak;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/protected")
    public String protectedHello() {
        return "Hello World, i was protected";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/secured")
    public String securedHello() {
        return "Hello World, i was secured";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Hello World from admin";
    }

    @PreAuthorize("customPerm('write')")
    @RequestMapping("/custom")
    public String custom() {
        return "Hello World, i am the custom one";
    }

}

