//package org.example.fullstacktodoapp;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//@Disabled
//class TodoServiceTest {
//    private final TodoRepository mockTodoRepo = mock(TodoRepository.class);
//    TodoService todoService = new TodoService(mockTodoRepo);
//
//    @Test
//    void getAll() {
//        List<Todo> expected = List.of(new Todo("123", "descrizzy", TodoStatus.OPEN));
//        when(mockTodoRepo.findAll()).thenReturn(expected);
//        assertEquals(expected, todoService.getAll());
//    }
//
//    @Test
//    void addTodo() {
//        String description = "descrizzy";
//        Todo created = new Todo(UUID.randomUUID().toString(), description);
//        when(mockTodoRepo.save(created)).thenReturn(created);
//        assertEquals(description, todoService.addTodo(description));
//    }
//
//    @Test
//    void getDetails() {
//        Todo expected = new Todo(UUID.randomUUID().toString(), "descrizzy");
//        when(mockTodoRepo.getById("1")).thenReturn(expected);
//        assertEquals(expected, todoService.getDetails("1"));
//    }
//
//    @Test
//    void updateTodo() {
//        String id = "1";
//        TodoDTO todoDTO = new TodoDTO("updated descrizzy", TodoStatus.IN_PROGRESS);
//        Todo updated = new Todo(id, todoDTO.description(), todoDTO.status());
//        when(mockTodoRepo.save(updated)).thenReturn(updated);
//        assertEquals(updated, todoService.updateTodo(id, todoDTO));
//    }
//
//    @Test
//    void deleteTodo(){
//        String id = "1";
//        Todo expected = new Todo(id, "descrizzy");
//        when(mockTodoRepo.getById(id)).thenReturn(expected);
//        assertEquals(expected, todoService.deleteTodo(id));
//    }
//}