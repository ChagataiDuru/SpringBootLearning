package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository repository;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<User> findAll(@RequestParam(value = "page", defaultValue = "0") int page) {
        int SIZE = 10;
        return this.repository.findAll(PageRequest.of(page, SIZE, Sort.by("first_name", "id")));
    }
    @GetMapping("{id}")
    public User findById(@PathVariable int id) {
        return this.repository.findById(id); //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public User insert(@RequestBody User user) {
        return this.repository.save(user);
    }
    @PutMapping("{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        User userDatabase = this.repository.findById(id);
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return this.repository.update(user);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.repository.deleteById(id);
    }

}
