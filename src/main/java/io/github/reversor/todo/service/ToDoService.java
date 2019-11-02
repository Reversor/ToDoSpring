package io.github.reversor.todo.service;

import io.github.reversor.todo.dao.ToDoRepository;
import io.github.reversor.todo.entity.ToDo;
import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Iterable<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public Iterable<ToDo> getAllOpened() {
        return toDoRepository.getAllByStartTimeAfter(OffsetDateTime.now());
    }

    public Iterable<ToDo> getAllClosed() {
        return toDoRepository.getAllByEndTimeBefore(OffsetDateTime.now());
    }

    public ToDo createNewToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }
}
