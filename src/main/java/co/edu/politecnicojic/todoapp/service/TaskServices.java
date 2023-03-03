package co.edu.politecnicojic.todoapp.service;

import co.edu.politecnicojic.todoapp.mapper.TaskInDTOToTask;
import co.edu.politecnicojic.todoapp.persistence.entity.Task;
import co.edu.politecnicojic.todoapp.persistence.entity.TaskStatus;
import co.edu.politecnicojic.todoapp.persistence.repository.TaskRepository;
import co.edu.politecnicojic.todoapp.service.dto.TaskInTDO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServices {

    private final TaskRepository taskRepository;
    private final TaskInDTOToTask taskInDTOToTask;

    public Task createTask(TaskInTDO taskInTDO){
        return taskRepository.save(taskInDTOToTask.mapper(taskInTDO));
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return taskRepository.findAllByTaskStatus(status);

    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }
}
