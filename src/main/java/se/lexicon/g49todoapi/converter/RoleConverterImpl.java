package se.lexicon.g49todoapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;
import se.lexicon.g49todoapi.domanin.entity.Role;

@Component
public class RoleConverterImpl implements RoleConverter {
    @Override
    public RoleDTOView toRoleDTO(Role entity) {
        return new RoleDTOView(entity.getId(), entity.getName());

    }

    @Override
    public Role toRoleEntity(RoleDTOView dto) {
        return new Role(dto.getId(), dto.getName());
    }
}
