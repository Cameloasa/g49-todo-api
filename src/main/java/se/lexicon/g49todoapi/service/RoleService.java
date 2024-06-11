package se.lexicon.g49todoapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;

import java.util.List;


public interface RoleService {
    List<RoleDTOView> getAll();
}
