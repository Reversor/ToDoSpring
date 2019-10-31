package io.github.reversor.todo.controller;

import io.github.reversor.todo.entity.ToDo;
import io.github.reversor.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewTodo(@RequestBody ToDo toDo) {
        toDoService.createNewToDo(toDo);
    }

}
