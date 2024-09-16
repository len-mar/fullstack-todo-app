package org.example.fullstacktodoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @GetMapping("/api/todo")
    public List<Todo> getAll() {
        return service.getAll();
    }

    @GetMapping("/board/todo")
    public List<Todo> getAllBoard() {
        return service.getAll();
    }

    @GetMapping("api/todo/{id}")
    public Todo getDetails(@PathVariable String id) {
        return service.getDetails(id);
    }

    @PutMapping("api/todo/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody TodoDTO todoDTO){
        return service.updateTodo(id, todoDTO);
    }

    @PostMapping("/api/todo")
    public String addTodo(@RequestBody String todo) {
        return service.addTodo(todo);
    }

    @DeleteMapping("api/todo/{id}")
    public Todo deleteTodo(@PathVariable String id){
        return service.deleteTodo(id);
    }


}
