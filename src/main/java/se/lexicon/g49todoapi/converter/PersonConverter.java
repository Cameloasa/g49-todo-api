package se.lexicon.g49todoapi.converter;

import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOView;
import se.lexicon.g49todoapi.domanin.entity.Person;

public interface PersonConverter {
    PersonDTOView toPersonDTOView(Person entity);
    Person toPersonEntity(PersonDTOForm dtoForm);

}
