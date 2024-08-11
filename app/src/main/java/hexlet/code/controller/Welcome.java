package hexlet.code.controller;

import hexlet.code.model.TestUser;
import hexlet.code.model.User;
import hexlet.code.repository.TestUserRepository;
import hexlet.code.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @Autowired
    private TestUserRepository repository;

    @PostMapping("/save")
    public String index(@RequestBody TestUser user) {
        repository.save(user);
        return "пользователь сохранен";
    }

}
