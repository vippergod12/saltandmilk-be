package saltandmilk.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import saltandmilk.dto.request.user.UserRequestCreateDto;
import saltandmilk.dto.response.UserResponseDto.UserResponseDto;
import saltandmilk.entities.user.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestCreateDto request);

    UserResponseDto toUserResponse(User user);

    List<UserResponseDto> toListUserResponseDto(List<User> users);
}
