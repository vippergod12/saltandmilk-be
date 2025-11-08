package saltandmilk.configs;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import saltandmilk.constants.PreDefineRole;
import saltandmilk.entities.user.Role;
import saltandmilk.entities.user.User;
import saltandmilk.repositories.user.RoleRepository;
import saltandmilk.repositories.user.UserRepository;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ApplicationInitConfig {
    final PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USERNAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            if(userRepository.findByUsername(ADMIN_USERNAME).isEmpty()){
                Role adminRole = roleRepository.save(Role.builder()
                        .name((PreDefineRole.ADMIN_ROLE))
                        .build());

                User admin = User.builder()
                        .username(ADMIN_USERNAME)
                        .password(passwordEncoder.encode( ADMIN_PASSWORD))
                        .email("dangnhattien1101@gmail.com")
                        .role(adminRole)
                        .build();

                userRepository.save(admin);
            }
        };
    }
}
