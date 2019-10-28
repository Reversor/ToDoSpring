package io.github.reversor.todo.dao;

import io.github.reversor.todo.entity.ToDo;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    @Override
    Iterable<ToDo> findAll();

    Iterable<ToDo> getAllByStartTimeNotContaining(OffsetDateTime dateTime);
}
