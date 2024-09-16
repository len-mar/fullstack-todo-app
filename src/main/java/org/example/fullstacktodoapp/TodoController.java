package org.example.fullstacktodoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @GetMapping
    public List<Todo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Todo getDetails(@PathVariable String id) {
        return service.getDetails(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody TodoDTO todoDTO){
        return service.updateTodo(id, todoDTO);
    }

    @PostMapping
    public String addTodo(@RequestBody String description) {
        return service.addTodo(description);
    }

    @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable String id){
        return service.deleteTodo(id);
    }


}
