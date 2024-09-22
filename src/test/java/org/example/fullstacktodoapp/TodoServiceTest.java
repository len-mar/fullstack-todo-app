package org.example.fullstacktodoapp;

import org.example.fullstacktodoapp.AiApi.AiApiService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoServiceTest {
    private final TodoRepository mockTodoRepo = mock(TodoRepository.class);
    private final AiApiService aiService = mock(AiApiService.class);

    TodoService todoService = new TodoService(mockTodoRepo, aiService);

    @Test
    void getAll() {
        List<Todo> expected = List.of(new Todo("123", "descrizzy", TodoStatus.OPEN));
        when(mockTodoRepo.findAll()).thenReturn(expected);
        assertEquals(expected, todoService.getAll());
    }

    // tests the actual addTodo method
    @Test
    void addTodo() {
        String description = "descrizzy";
        given(aiService.spellcheckTodo(description))
                .willReturn(description);
        String todoJson = """
                { "description": "descrizzy",
                "status": "OPEN"
                }
                """;
        Todo created = new Todo(UUID.randomUUID().toString(), description);
        when(mockTodoRepo.save(created)).thenReturn(created);
        assertEquals(description, todoService.addTodo(todoJson));
    }

    @Test
    void getDetails() {
        Todo expected = new Todo(UUID.randomUUID().toString(), "descrizzy");
        when(mockTodoRepo.getById("1")).thenReturn(expected);
        assertEquals(expected, todoService.getDetails("1"));
    }

    @Test
    void updateTodo() {
        String id = "1";
        TodoDTO todoDTO = new TodoDTO("updated descrizzy", TodoStatus.IN_PROGRESS);
        Todo updated = new Todo(id, todoDTO.description(), todoDTO.status());
        when(mockTodoRepo.save(updated)).thenReturn(updated);
        assertEquals(updated, todoService.updateTodo(id, todoDTO));
    }

    @Test
    void deleteTodo(){
        String id = "1";
        Todo expected = new Todo(id, "descrizzy");
        when(mockTodoRepo.getById(id)).thenReturn(expected);
        assertEquals(expected, todoService.deleteTodo(id));
    }
}