package se.lexicon.g49todoapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.g49todoapi.domanin.dto.UserDTOView;
import se.lexicon.g49todoapi.domanin.entity.User;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDTOView toUserDTO(User entity) {
       UserDTOView dto = new UserDTOView(entity.getEmail(), entity.getRoles());
       return dto;
    }

    @Override
    public User toUserEntity(UserDTOView dto) {
        return new User(dto.getEmail());
    }
}
