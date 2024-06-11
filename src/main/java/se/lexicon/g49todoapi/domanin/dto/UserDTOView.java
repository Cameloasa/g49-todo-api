package se.lexicon.g49todoapi.domanin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTOView {
    private String email;
    private Set<RoleDTOView> roles;
}
