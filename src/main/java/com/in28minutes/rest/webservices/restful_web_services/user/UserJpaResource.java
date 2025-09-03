package com.in28minutes.rest.webservices.restful_web_services.user;

import com.in28minutes.rest.webservices.restful_web_services.jpa.PostRepository;
import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private PostRepository postRepository;
    private UserRepository repository;

    // constructor dependency injection
    public UserJpaResource(PostRepository postRepository, UserRepository repository) {
        this.postRepository = postRepository;
        this.repository = repository;
    }

    // get all users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    // get user by user id
    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        return user.orElse(null);
    }

    // delete a user
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    // add a user
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);

        //users/4 => /users /{id}, user.getId()
        URI Location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(Location).build();
    }

    // ---------------------------------------------------------------------------------------
    // get all the posts of a specific user
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostForAUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        return user.get().getPosts();
    }

    // create a post of a specific user
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForAUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI Location = ServletUriComponentsBuilder  // create a additional URI to get the link of new post created in response header
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(Location).build();
    }
}
