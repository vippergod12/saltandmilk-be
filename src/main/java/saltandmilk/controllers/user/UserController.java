package saltandmilk.controllers.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import saltandmilk.dto.request.user.UserRequestCreateDto;
import saltandmilk.dto.request.user.UserRequestUpdateDto;
import saltandmilk.dto.response.ApiResp;
import saltandmilk.dto.response.UserResponseDto.UserResponseDto;
import saltandmilk.intefaces.user.IUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    final IUserService userService;

    @PostMapping
    ApiResp<UserResponseDto> createUser(@RequestBody @Validated UserRequestCreateDto request) {
        return ApiResp.<UserResponseDto>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    ApiResp<List<UserResponseDto>> getUsers() {
        return ApiResp.<List<UserResponseDto>>builder()
                .result(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResp<UserResponseDto> getUser(@PathVariable("userId") UUID userId) {
        return ApiResp.<UserResponseDto>builder()
                .result(userService.getUserById(userId))
                .build();
    }

    @GetMapping("/my-info")
    ApiResp<UserResponseDto> getMyInfo() {
        return ApiResp.<UserResponseDto>builder()
                .result(userService.getMyInfo())
                .build();
    }

//    @DeleteMapping("/{userId}")
//    ApiResp<String> deleteUser(@PathVariable String userId) {
//        userService.deleteUser(userId);
//        return ApiResponse.<String>builder().result("User has been deleted").build();
//    }

    @PutMapping("/{userId}")
    ApiResp<UserResponseDto> updateUser(@PathVariable UUID userId, @RequestBody UserRequestUpdateDto request) {
        return ApiResp.<UserResponseDto>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }
}
