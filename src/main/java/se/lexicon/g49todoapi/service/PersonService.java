package se.lexicon.g49todoapi.service;

import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOView;

import java.util.List;

public interface PersonService {
    //create
    PersonDTOView create(PersonDTOForm dtoForm);
    // findById
    PersonDTOView findById(Long id);
    // findAll
    List<PersonDTOView> findAll();
    // update
    PersonDTOView update(PersonDTOForm dtoForm);
    // delete
    void delete(Long id);
}
