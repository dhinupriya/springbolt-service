package com.springbolt.springbolt_service.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mongo_users")
public class MongoUser {
    @Id
    private String id;
    private String name;

    public MongoUser(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
