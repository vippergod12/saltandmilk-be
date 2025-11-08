package saltandmilk.intefaces.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import saltandmilk.dto.request.user.ChangePasswordRequestDto;
import saltandmilk.dto.request.user.UserRequestCreateDto;
import saltandmilk.dto.request.user.UserRequestUpdateDto;
import saltandmilk.dto.response.UserResponseDto.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<UserResponseDto> getAllUsers();

    Page<UserResponseDto> searchUsers (String name, String role, Boolean gender, Boolean status
            , Pageable pageable);

    UserResponseDto getUserById(UUID userid);

    UserResponseDto createUser(UserRequestCreateDto userRequest);

    UserResponseDto updateUser(UUID userId, UserRequestUpdateDto userRequest);

    void changePassword(String username, ChangePasswordRequestDto request);

    UserResponseDto getMyInfo();
}
