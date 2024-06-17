package se.lexicon.g49todoapi.domanin.dto;


import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class UserDTOForm {

    private String email;
    private String password;
    private Set<RoleDTOForm> roles;
}
