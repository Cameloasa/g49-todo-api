package se.lexicon.g49todoapi.domanin.dto;

import lombok.*;
import se.lexicon.g49todoapi.domanin.entity.Task;
import se.lexicon.g49todoapi.domanin.entity.User;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class PersonDTOView {
    private Long id;
    private String name;

}
