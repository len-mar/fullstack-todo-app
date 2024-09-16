package org.example.fullstacktodoapp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    // todo: find a way to display just the descrippy
    // .stream().map(t -> t.description()).toList()
    public List<Todo> getAll() {
        return repository.findAll();
    }

    public String addTodo(String description) {
        Todo created = new Todo(UUID.randomUUID().toString(), description);
        repository.save(created);
        // todo: find out why this works but the frontend still displays object notation
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
