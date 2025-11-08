package saltandmilk.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import saltandmilk.constants.PreDefineRole;
import saltandmilk.dto.request.user.ChangePasswordRequestDto;
import saltandmilk.dto.request.user.UserRequestCreateDto;
import saltandmilk.dto.request.user.UserRequestUpdateDto;
import saltandmilk.dto.response.UserResponseDto.UserResponseDto;
import saltandmilk.entities.user.Role;
import saltandmilk.entities.user.User;
import saltandmilk.exceptions.AppException;
import saltandmilk.exceptions.ErrorCode;
import saltandmilk.intefaces.user.IUserService;
import saltandmilk.mappers.UserMapper;
import saltandmilk.repositories.user.RoleRepository;
import saltandmilk.repositories.user.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserServiceImpl implements IUserService {

    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;
    final UserMapper userMapper;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDto> getAllUsers() {
        var list = userRepository.findAll();
        return userMapper.toListUserResponseDto(list);
    }


    @Override
    public Page<UserResponseDto> searchUsers(String name, String role, Boolean gender, Boolean status, Pageable pageable) {
        return null;
    }


    @Override
    public UserResponseDto getUserById(UUID userid) {
        return userMapper.toUserResponse(
                userRepository.findById(userid).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    @Override
    public UserResponseDto createUser(UserRequestCreateDto userRequest) {
        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = new Role();
        role = roleRepository.findByName(PreDefineRole.USER_ROLE);

        user.setRole(role);
        try{
            user = userRepository.save(user);
        }catch(DataIntegrityViolationException ex){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponseDto updateUser(UUID userId, UserRequestUpdateDto userRequest) {
        return null;
    }

    @Override
    public void changePassword(String username, ChangePasswordRequestDto request) {

    }

    @Override
    public UserResponseDto getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

}
