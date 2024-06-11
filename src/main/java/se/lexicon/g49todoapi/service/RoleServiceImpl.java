package se.lexicon.g49todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;
import se.lexicon.g49todoapi.domanin.entity.Role;
import se.lexicon.g49todoapi.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<RoleDTOView> getAll() {
        List <Role> roles =roleRepository.findAll();
        return List.of();
    }
}
