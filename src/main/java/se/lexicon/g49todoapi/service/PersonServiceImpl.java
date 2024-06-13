package se.lexicon.g49todoapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.converter.PersonConverter;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOView;
import se.lexicon.g49todoapi.domanin.entity.Person;
import se.lexicon.g49todoapi.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonConverter personConverter;

    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public PersonDTOView create(PersonDTOForm form) {
        Person person = personConverter.toPersonEntity(form);
        Person savedPerson = personRepository.save(person);
        return personConverter.toPersonDTOView(savedPerson);;
    }

    @Override
    public PersonDTOView findById(Long id) {
        return null;
    }

    @Override
    public List<PersonDTOView> findAll() {
        return List.of();
    }

    @Override
    public PersonDTOView update(Long id, PersonDTOForm form) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
