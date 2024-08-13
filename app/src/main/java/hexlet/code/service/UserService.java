package hexlet.code.service;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserCreateDTO dto);

    UserDTO showUser(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long id, UserUpdateDTO dto);

    void deleteUser(Long id);
}
