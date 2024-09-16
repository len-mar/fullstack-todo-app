package org.example.fullstacktodoapp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository <Todo, String> {
    Todo getById(String id);
}
