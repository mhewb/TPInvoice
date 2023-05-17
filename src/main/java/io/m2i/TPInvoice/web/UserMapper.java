package io.m2i.TPInvoice.web;

import io.m2i.TPInvoice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User User);
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roleList", ignore = true)
    User fromDTO(UserDTO UserDTO);

}
