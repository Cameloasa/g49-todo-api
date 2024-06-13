package se.lexicon.g49todoapi.domanin.dto;

import lombok.*;
import se.lexicon.g49todoapi.domanin.entity.Person;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTOForm {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Boolean done;
    private Person person;
}
