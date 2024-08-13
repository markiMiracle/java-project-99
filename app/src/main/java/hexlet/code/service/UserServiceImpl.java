package hexlet.code.service;


import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    private UserMapper mapper;


    @Override
    public UserDTO createUser(UserCreateDTO dto) {
        var user = mapper.map(dto);
        repository.save(user);
        return mapper.map(user);
    }

    @Override
    public UserDTO showUser(Long id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id " + id + " не существует")));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity))
                .toList();
    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateDTO userData) {
        var currentUser = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id " + id + " не существует"));
        mapper.update(userData, currentUser);
        repository.save(currentUser);
        return mapper.map(currentUser);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
