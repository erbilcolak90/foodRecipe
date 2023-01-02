package com.kitchen.www.services;

import com.kitchen.www.entities.User;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.UserInput;
import com.kitchen.www.repositories.entities.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow();
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Page<User> getAllUser(PaginationInput paginationInput){
        Pageable pageable = PageRequest.of(paginationInput.getPage(), paginationInput.getSize(), Sort.by(Sort.Direction.ASC, paginationInput.getSortBy()));
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User addUser(UserInput userInput){
        User tempUser = new User();
        tempUser.setName(userInput.getName());
        tempUser.setSurname(userInput.getSurname());
        tempUser.setUsername(userInput.getUsername());
        tempUser.setPassword(userInput.getPassword());
        tempUser.setCreateDate(new Date());

        userRepository.save(tempUser);
        return tempUser;
    }

    @Transactional
    public User updateUser(UserInput userInput){
        User tempUser = userRepository.findById(userInput.getId()).orElseThrow();
        tempUser.setName(userInput.getName());
        tempUser.setSurname(userInput.getSurname());
        tempUser.setUsername(userInput.getUsername());
        tempUser.setPassword(userInput.getPassword());

        userRepository.save(tempUser);

        return tempUser;
    }

    @Transactional
    public String deleteUser(String id){
        User tempUser= userRepository.findById(id).orElseThrow();
        tempUser.setDeleted(true);

        userRepository.save(tempUser);
        return "user deleted.";
    }

}
