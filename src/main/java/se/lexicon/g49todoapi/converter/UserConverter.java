package se.lexicon.g49todoapi.converter;

import se.lexicon.g49todoapi.domanin.dto.UserDTOView;
import se.lexicon.g49todoapi.domanin.entity.User;

public interface UserConverter {

    UserDTOView toUserDTO(User entity);
    User toUserEntity(UserDTOView dto);
}
