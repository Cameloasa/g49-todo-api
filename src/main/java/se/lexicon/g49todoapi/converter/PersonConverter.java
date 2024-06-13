package se.lexicon.g49todoapi.converter;

import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOView;
import se.lexicon.g49todoapi.domanin.entity.Person;

public interface PersonConverter {
    PersonDTOView toPersonDTO(Person entity);
    Person toPersonEntity(PersonDTOView dto);
    PersonDTOForm toPersonDTOForm(Person entity);


}
