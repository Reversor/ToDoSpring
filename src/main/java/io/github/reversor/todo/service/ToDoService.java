package io.github.reversor.todo.service;

import io.github.reversor.todo.dao.ToDoRepository;
import io.github.reversor.todo.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createNewToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

}
