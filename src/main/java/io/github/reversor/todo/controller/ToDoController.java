package io.github.reversor.todo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.github.reversor.todo.entity.ToDo;
import io.github.reversor.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long createNewToDo(@RequestBody ToDo toDo) {
        return toDoService.createNewToDo(toDo).getId();
    }

    @GetMapping(value = "list", produces = APPLICATION_JSON_VALUE)
    public Iterable<ToDo> getAllToDo() {
        return toDoService.getAll();
    }

    @GetMapping(value = "list/opened", produces = APPLICATION_JSON_VALUE)
    public Iterable<ToDo> getOpenedToDos() {
        return toDoService.getAllOpened();
    }

    @GetMapping(value = "list/closed", produces = APPLICATION_JSON_VALUE)
    public Iterable<ToDo> getClosedToDos() {
        return toDoService.getAllClosed();
    }

}
