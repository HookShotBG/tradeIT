package com.infom.tradeit.demo.restcontroller;

import com.infom.tradeit.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infom.tradeit.demo.repositories.UserRepository;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        // Alle Karten aus dem Repository laden und der cards-Variable zuweisen
        System.out.println("penisman");
        List<User> users = userRepository.findAll();
        // Wenn die Liste Einträge enthält...
        if (users != null && !users.isEmpty()) {
            // ... dann diese als Body zurückgeben
            return new ResponseEntity(users, HttpStatus.OK);
        } else {
            // ... ansonsten ResourceNotFoundException (404)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }

}
