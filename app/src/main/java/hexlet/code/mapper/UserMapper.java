package hexlet.code.mapper;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mindrot.jbcrypt.BCrypt;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    @Mapping(source = "password", qualifiedByName = "getPasswordHash", target = "passwordDigest")
    User map(UserCreateDTO dto);


    UserDTO map(User model);

    @Mapping(source = "password", qualifiedByName = "getPasswordHash", target = "passwordDigest")
    void update(UserUpdateDTO dto, @MappingTarget User model);

    @Named("getPasswordHash")
    default String getPasswordHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}