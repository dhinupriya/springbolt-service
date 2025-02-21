package com.springbolt.springbolt_service.service;

import com.springbolt.springbolt_service.model.MongoUser;
import com.springbolt.springbolt_service.model.User;
import com.springbolt.springbolt_service.repository.MongoUserRepository;
import com.springbolt.springbolt_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired private MongoUserRepository mongoUserRepository;
    @Autowired private StringRedisTemplate redisTemplate;
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;

    public User saveUser(User user) {
        Boolean userExists = redisTemplate.hasKey(user.getId());
        if (userExists) {
            System.out.println("User already exists in Redis cache: " + redisTemplate.opsForValue().get(user.getId()));
            logger.error("User already exists in Redis cache:" + redisTemplate.opsForValue().get(user.getId()));
            User redisUser = new User();
            redisUser.setId(user.getId());
            redisUser.setName(redisTemplate.opsForValue().get(user.getId()));
            return redisUser;
        }
        redisTemplate.opsForValue().set(user.getId(), user.getName());
        kafkaTemplate.send("user-topic", user.getName());
        userRepository.save(user);
        logger.info("user added to mysql");
        mongoUserRepository.save(new MongoUser(user.getId(), user.getName()));
        logger.info("user added to mongo");
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> mongoUserRepository.save(new MongoUser(user.getId(), user.getName())));
        return users;
    }

    public List<MongoUser> getAllMongoUsers() {
        return mongoUserRepository.findAll();
    }
}
