package com.tradeit.tradeitinman.restcontroller;

import com.tradeit.tradeitinman.entities.User;
import com.tradeit.tradeitinman.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // Single user
    @GetMapping("/users/{id}")
    public User singleUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find user" + id));
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id).map(user-> {
            user.setNachname(newUser.getNachname());
            user.setAktienhandel(newUser.getAktienhandel());
            user.setGeburtsdatum(newUser.getGeburtsdatum());
            user.setGuthaben(newUser.getGuthaben());
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
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/users/money")
    public List<User> getMoney(){
        return userRepository.findAllByOrderByGuthaben();
    }

    @GetMapping("/users/ri/{money}")
    public List<User> getPreciousCustomers(@PathVariable double money){
        return userRepository.findUsersWithMoreMoneyThan(money);
    }

    @GetMapping("/users/ri2/{money}")
    public List<User> getPreciousCustomers2(@PathVariable double money){
        return userRepository.findUsersWithSomeAttributes(money);
    }

    @GetMapping("/users/query/{id}")
    public User getUserByIdentity(@PathVariable String id){
        return userRepository.findUserByIdnr(id);
    }

    @GetMapping("/users/querys/{id}")
    public List<User> getUserByIdentitys(@PathVariable String id){
        return userRepository.findUsersWhichContainIdnr(id);
    }

    @GetMapping("/users/query/{pre}/{last}")
    public List<User> getUserByIdentity(@PathVariable String pre, @PathVariable String last){
        return userRepository.findUserByVorUndNachname(pre, last);
    }

}
