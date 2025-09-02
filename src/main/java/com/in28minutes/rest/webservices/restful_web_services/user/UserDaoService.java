package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static{
        users.add(new User(++usersCount,"vishal", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"vicky", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"gaurav", LocalDate.now().minusYears(20)));
    }
    // find all users
    public List<User> findAll(){
        return  users;
    }

    // save users
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    // find a specific user
    public User findOne(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
//        for(User user: users){
//            if(user.getId() == id){
//                return user;
//            }
//        }

    }

    // delete a user by id
    public void deleteById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
