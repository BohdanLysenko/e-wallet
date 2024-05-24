package ua.lysenko.userservice.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ua.lysenko.userservice.dto.UserDTO;
import ua.lysenko.userservice.entity.Role;
import ua.lysenko.userservice.entity.User;
import ua.lysenko.userservice.ui.models.UserResponseModel;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User user);

    @Mapping(source = "role", target = "role", qualifiedByName = "mapRole")
    UserResponseModel toUserResponseModel(UserDTO userDetailsById);


    @Named("mapRole")
    static String mapErrorMsg(Role role) {
        if (role.equals(Role.ROLE_USER)) {
            return "User";
        } else return "Admin";
    }
}