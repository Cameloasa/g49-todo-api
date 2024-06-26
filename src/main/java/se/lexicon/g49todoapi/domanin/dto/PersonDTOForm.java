package se.lexicon.g49todoapi.domanin.dto;

import lombok.*;
import se.lexicon.g49todoapi.domanin.entity.Task;
import se.lexicon.g49todoapi.domanin.entity.User;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class PersonDTOForm {
    private Long id;
    private String name;
    private String userEmail;


}
