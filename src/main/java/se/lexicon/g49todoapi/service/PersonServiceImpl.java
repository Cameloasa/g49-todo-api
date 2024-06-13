package se.lexicon.g49todoapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.converter.PersonConverter;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOView;
import se.lexicon.g49todoapi.domanin.entity.Person;
import se.lexicon.g49todoapi.exception.DataDuplicateException;
import se.lexicon.g49todoapi.exception.DataNotFoundException;
import se.lexicon.g49todoapi.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonConverter personConverter;

    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public PersonDTOView create(PersonDTOForm dtoForm) {
        //Check the param
        if(dtoForm == null) throw new IllegalArgumentException("This Form is not accepted.");
        //2. Check if the person exist in the database
        boolean personExists = personRepository.existsById(dtoForm.getId());
        //3.if person exist throw an Exception - Data Duplicate Exception
        if(personExists) {
            throw new DataDuplicateException("The Person already exists.");
        }
        // 4. Convert PersonDTOForm to Person entity using PersonConverter
        Person person = personConverter.toPersonEntity(dtoForm);
        //5. Save the Person to the database
        Person savedPerson = personRepository.save(person);
        // 6. Convert saved Person entity to PersonDTOView using PersonConverter
        return  personConverter.toPersonDTOView(savedPerson);
    }

    @Override
    public PersonDTOView findById(Long id) {
        //1.Find the person by id in repository
        Person person = personRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("The Person does not exist."));
        //2.Convert to DTO view
        return personConverter.toPersonDTOView(person);
    }

    @Override
    public List<PersonDTOView> findAll() {
        //1. Retrieve all persons
        List<Person> persons = personRepository.findAll();
        //2. Convert to DTO views using stream, map and collection
        return persons.stream()
                .map(personConverter::toPersonDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTOView update(PersonDTOForm dtoForm) {
        // Check the param
        if(dtoForm == null) throw new IllegalArgumentException("This Form is not accepted.");
        // Find the existing person
        Person existingPerson = personRepository.findById(dtoForm.getId()).
                orElseThrow(()-> new DataNotFoundException("The Person does not exist."));
        // Update the person's details
        existingPerson.setName(dtoForm.getName());
        Person updatedPerson = personRepository.save(existingPerson);
        // Convert to DTO view and return
        return personConverter.toPersonDTOView(updatedPerson);
    }

    @Override
    public void delete(Long id) {
        // Check if the person exists
        if (!personRepository.existsById(id)) {
            throw new DataNotFoundException("Person not found with id: " + id);
        }
        // Delete the person
        personRepository.deleteById(id);
    }
    }

