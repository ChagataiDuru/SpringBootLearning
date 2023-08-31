package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    private final IUserRepository repository;
    public UserController(IUserRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<User> findAll(@RequestParam(value = "page", defaultValue = "0") int page) {
        int SIZE = 10;
        return this.repository.findAll();
    }
    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable int id) {
        return this.repository.findById(id); //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User body) {
        User user = this.repository.save(body);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody User user) {
        Optional<User> userDatabase = this.repository.findById(id);
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.repository.deleteById(id);
    }

}
