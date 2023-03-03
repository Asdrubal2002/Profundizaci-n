package co.edu.politecnicojic.todoapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="create_date")
    private LocalDateTime createDate;
    @Column(name="finished")
    private boolean finished;
    @Column(name="task_status")
    private TaskStatus taskStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && finished == task.finished && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(createDate, task.createDate) && taskStatus == task.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
