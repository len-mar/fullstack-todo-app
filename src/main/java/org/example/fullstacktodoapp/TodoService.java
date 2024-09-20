package org.example.fullstacktodoapp;
import lombok.RequiredArgsConstructor;
import org.example.fullstacktodoapp.AiApi.AiApiService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;
    private final AiApiService aiService;

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public String addTodo(String todoJson) {
        // parses json and isolates description
        JSONObject jsonObject = new JSONObject(todoJson);
        String description = jsonObject.getString("description");

        // spellchecks description
        description = aiService.spellcheckTodo(description);

        Todo created = new Todo(UUID.randomUUID().toString(), description, TodoStatus.OPEN);
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
