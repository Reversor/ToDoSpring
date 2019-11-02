package io.github.reversor.todo.dao;

import io.github.reversor.todo.entity.ToDo;
import java.time.OffsetDateTime;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    Iterable<ToDo> getAllByStartTimeAfter(OffsetDateTime dateTime);
    Iterable<ToDo> getAllByEndTimeBefore(OffsetDateTime dateTime);
}
