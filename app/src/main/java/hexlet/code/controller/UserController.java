package hexlet.code.controller;


import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.model.User;
import hexlet.code.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserRepository repository;

    private UserMapper mapper;

    @GetMapping
    public List<UserDTO> index() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity))
                .toList();
    }

    @GetMapping("/{id}")
    public UserDTO show(@PathVariable("id") Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id " + id + " не существует")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserCreateDTO userData) {
        User user = mapper.map(userData);
        repository.save(user);
        return mapper.map(user);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserUpdateDTO userData) {
        var currentUser = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id " + id + " не существует"));
        mapper.update(userData, currentUser);
        repository.save(currentUser);
        return mapper.map(currentUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
