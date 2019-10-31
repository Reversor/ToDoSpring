package io.github.reversor.todo.controller;

import io.github.reversor.todo.dao.ToDoRepository;
import io.github.reversor.todo.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class ToDoController {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewTodo(@RequestBody ToDo toDo) {
        toDoRepository.save(toDo);
    }

}
