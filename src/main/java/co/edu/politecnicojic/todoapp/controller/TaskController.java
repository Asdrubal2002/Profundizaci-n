package co.edu.politecnicojic.todoapp.controller;

import co.edu.politecnicojic.todoapp.persistence.entity.Task;
import co.edu.politecnicojic.todoapp.persistence.entity.TaskStatus;
import co.edu.politecnicojic.todoapp.service.TaskServices;
import co.edu.politecnicojic.todoapp.service.dto.TaskInTDO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServices taskService;

    @PostMapping
    public Task createTask(TaskInTDO taskInTDO){
        return taskService.createTask(taskInTDO);
    }
    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return taskService.findAllByTaskStatus(status);
    }

    @GetMapping()
    public List<Task> findAll(){
        return taskService.findAll();
    }

}