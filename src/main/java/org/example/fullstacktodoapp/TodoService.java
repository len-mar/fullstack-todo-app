package org.example.fullstacktodoapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public String addTodo(String todo) {
        // this somehow parses the string object to retrieve just the description
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(todo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Todo created = new Todo(UUID.randomUUID().toString(), node.get("description").asText());
        repository.save(created);
        return created.description();
    }


    public Todo getDetails(String id) {
        return repository.getById(id);
    }

    public Todo updateTodo(String id, TodoDTO todoDTO) {
        Todo updated = new Todo(id, todoDTO.description(), todoDTO.status());
        repository.save(updated);
        return updated;
    }

    public Todo deleteTodo(String id) {
        Todo deleted = repository.getById(id);
        repository.removeById(id);
        return deleted;
    }
}
