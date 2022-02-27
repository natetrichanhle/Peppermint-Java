package com.nate.peppermint.services;

import java.util.Optional;

import com.nate.peppermint.models.LoginUser;
import com.nate.peppermint.models.User;
import com.nate.peppermint.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO - Reject values or register if no errors:
        // Reject if email is taken (present in database)
        Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
        if(potentialUser.isPresent()){
            result.rejectValue("email", "Unique", "Email is taken");
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("confirm", "Matches", "Passwords do not match");
        }
        // Return null if result has errors
        if(result.hasErrors()){
            return null;
        } else {
            // Hash and set password, save user to database
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
         // TO-DO - Reject values:
        
    	// Find user in the DB by email
        Optional<User> potentialUser = userRepository.findByEmail(newLoginObject.getEmail());
        // Reject if NOT present
        if(!potentialUser.isPresent()){
            result.rejectValue("email", "somethingEmail", "Invalid Login");
            return null;
        } 
        User user = potentialUser.get();
        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())){
            result.rejectValue("email", "somethingpass", "Invalid Login");
        }
        // Return null if result has errors
        if(result.hasErrors()){
            return null;
        } else {
            // Otherwise, return the user object
            return user;
        }
    }

    public User findOne(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            return null;
        }
    }
}


