package org.example.fullstacktodoapp;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

public record Todo(@Primary @Id String id, String description, TodoStatus status) {
    Todo(String id, String description){
        this(id, description, TodoStatus.OPEN);
    }
}
