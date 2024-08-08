package hexlet.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {


    @GetMapping("/welcome")
    public String index() {
        return "Welcome!";
    }

}
