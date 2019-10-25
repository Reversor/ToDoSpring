package io.github.reversor.todo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    @Column(name = "start_time", columnDefinition = "TIMESTAMP WITH TIMEZONE")
    private OffsetDateTime startTime;
    @Column(name = "end_time", columnDefinition = "TIMESTAMP WITH TIMEZONE")
    private OffsetDateTime endTime;

    public long getId() {
        return id;
    }

    public ToDo setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToDo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToDo setDescription(String description) {
        this.description = description;
        return this;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public ToDo setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public ToDo setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return id == toDo.id &&
                name.equals(toDo.name) &&
                Objects.equals(description, toDo.description) &&
                startTime.equals(toDo.startTime) &&
                Objects.equals(endTime, toDo.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startTime, endTime);
    }
}
