package se.lexicon.g49todoapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOView;
import se.lexicon.g49todoapi.domanin.entity.Person;

import java.util.stream.Collectors;

@Component
public class PersonConverterImpl implements PersonConverter {

    @Override
    public PersonDTOView toPersonDTO(Person entity) {
        return PersonDTOView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .user(entity.getUser())
                .tasks(entity.getTasks())
                .build();
    }

    @Override
    public Person toPersonEntity(PersonDTOView dto) {
        return Person.builder()
                .id(dto.getId())
                .name(dto.getName())
                .user(dto.getUser())
                .tasks(dto.getTasks().stream().collect(Collectors.toList()))
                .build();
    }

    @Override
    public PersonDTOForm toPersonDTOForm(Person entity) {
        return PersonDTOForm.builder()
                .id(entity.getId())
                .name(entity.getName())
                .user(entity.getUser())
                .tasks(entity.getTasks())
                .build();
    }
}

