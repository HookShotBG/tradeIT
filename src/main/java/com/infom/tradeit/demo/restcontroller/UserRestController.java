package com.infom.tradeit.demo.restcontroller;

import com.infom.tradeit.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.infom.tradeit.demo.repositories.UserRepository;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // Single item
    @GetMapping("/users/{id}")
    User singleUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find user" + id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id).map(user-> {
            user.setNachname(newUser.getNachname());
            user.setAktienhandel(newUser.getAktienhandel());
            user.setGeburtsdatum(newUser.getGeburtsdatum());
            user.setGuthaben(newUser.getGuthaben());
            user.setIdAdresse(newUser.getIdAdresse());
            user.setIdentitaetskartennr(newUser.getIdentitaetskartennr());
            user.setVorname(newUser.getVorname());
            user.setZahlungsinformation(newUser.getZahlungsinformation());
            return userRepository.save(user);
        }).orElseGet(() -> {
            //if user was not altered, save new user
            newUser.setIdUser(id);
            return userRepository.save(newUser);
        });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
