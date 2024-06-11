package se.lexicon.g49todoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.domanin.dto.UserDTOForm;
import se.lexicon.g49todoapi.domanin.dto.UserDTOView;
import se.lexicon.g49todoapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTOView register(UserDTOForm dtoForm) {
        return null;
    }

    @Override
    public UserDTOView getByEmail(String email) {
        return null;
    }

    @Override
    public void disableEmail(String email) {

    }

    @Override
    public void enableEmail(String email) {

    }
}
