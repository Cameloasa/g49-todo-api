package se.lexicon.g49todoapi.service;

import se.lexicon.g49todoapi.domanin.dto.UserDTOForm;
import se.lexicon.g49todoapi.domanin.dto.UserDTOView;

public interface UserService {
    //register user(email, password,role)
    UserDTOView register(UserDTOForm dtoForm);
    //Find user by email
    UserDTOView getByEmail(String email);
    //disable user by email
    void disableEmail(String email);
    //enable user by email
    void enableEmail(String email);

}
