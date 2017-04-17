package org.ksea.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mexican on 2017/4/17.
 */


@RestController
@EnableAutoConfiguration
public class HomeApplication {
    @RequestMapping(value = "/index")
    @ResponseBody
    public String index() {
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeApplication.class, args);
    }
}
