package se.lexicon.g49todoapi.converter;

import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;
import se.lexicon.g49todoapi.domanin.entity.Role;

public interface RoleConverter {

    RoleDTOView toRoleDTO(Role entity);
    Role toRoleEntity(RoleDTOView dto);
}
