package saltandmilk.dto.response.UserResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import saltandmilk.entities.user.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
    String username;
    String full_name;
    String password;
    String email;
    Role role;
}
