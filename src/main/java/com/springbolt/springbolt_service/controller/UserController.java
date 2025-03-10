package com.springbolt.springbolt_service.controller;

import com.springbolt.springbolt_service.model.MongoUser;
import com.springbolt.springbolt_service.model.Post;
import com.springbolt.springbolt_service.model.User;
import com.springbolt.springbolt_service.service.RestTemplateService;
import com.springbolt.springbolt_service.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;
    private RestTemplateService restTemplateService;

    @Autowired
    public UserController(UserService userService,RestTemplateService restTemplateService){
        this.userService=userService;
        this.restTemplateService=restTemplateService;
    }

    @PostMapping("/save")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/mongo")
    public List<MongoUser> getMongoUsers() {

        return userService.getAllMongoUsers();
    }

    @GetMapping("/Posts/{id}")
    public Post getPostById(@PathVariable  int id){
        return restTemplateService.getRestTemplatePostById(id);
    }


}
