package se.lexicon.g49todoapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;
import se.lexicon.g49todoapi.domanin.dto.UserDTOView;
import se.lexicon.g49todoapi.domanin.entity.Role;
import se.lexicon.g49todoapi.domanin.entity.User;

import java.util.stream.Collectors;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDTOView toUserDTO(User entity) {
        return UserDTOView.builder()
                .email(entity.getEmail())
                .roles(entity.getRoles().stream()
                        .map(role -> RoleDTOView.builder()
                                .name(role.getName())
                                .build())
                        .collect(Collectors.toSet()))
                                .build();

    }

    @Override
    public User toUserEntity(UserDTOView dto) {
        return User.builder()
                .email(dto.getEmail())
                .roles(dto.getRoles().stream()
                        .map(roleDTOView -> Role.builder()
                                .name(roleDTOView.getName())
                                .build())
                        .collect(Collectors.toSet()))
                .build();

    }
}
