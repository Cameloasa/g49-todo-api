package se.lexicon.g49todoapi.service;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.converter.TaskConverter;
import se.lexicon.g49todoapi.domanin.dto.PersonDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;
import se.lexicon.g49todoapi.domanin.entity.Person;
import se.lexicon.g49todoapi.domanin.entity.Task;
import se.lexicon.g49todoapi.exception.DataDuplicateException;
import se.lexicon.g49todoapi.exception.DataNotFoundException;
import se.lexicon.g49todoapi.repository.PersonRepository;
import se.lexicon.g49todoapi.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private TaskConverter taskConverter;
    private PersonRepository personRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskConverter taskConverter, PersonRepository personRepository) {
        this.taskRepository = taskRepository;
        this.taskConverter = taskConverter;
        this.personRepository = personRepository;
    }

    @Override
    public TaskDTOView create(TaskDTOForm dtoForm) {
        //Check if task exist in database
        if (dtoForm == null) throw new IllegalArgumentException("TaskDTOForm is null");
        //Check if the task exist in the database, if exist already throw a data duplicate exception
        boolean taskExists = taskRepository.existsById(dtoForm.getId());
        if (taskExists)
            throw new DataDuplicateException("Task already exists");
        //Convert TaskDTOForm to TaskEntity using converter
        Task task = taskConverter.toTaskEntity(dtoForm);
        //Save task to the database
        Task savedTask = taskRepository.save(task);
        //Convert savedTask to TaskDTOView and return
        return taskConverter.toTaskDTOView(savedTask);
    }

    @Override
    public TaskDTOView findById(Long id) {
        //1.Find the task by id in repository else throw exception
        if (id == null) throw new IllegalArgumentException("TaskDTOForm is null");
        Task task = taskRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Task not found"));
        //2.Convert to DTO view
        return taskConverter.toTaskDTOView(task);
    }

    @Override
    public TaskDTOView update(TaskDTOForm dtoForm) {
        // Check the param
        if (dtoForm == null) throw new IllegalArgumentException("This Form is not accepted.");
        // Find the existing task
        Task existingTask = taskRepository.findById(dtoForm.getId()).
                orElseThrow(() -> new DataNotFoundException("The task does not exist."));
        // Update the task details
        existingTask.setTitle(dtoForm.getTitle());
        existingTask.setDescription(dtoForm.getDescription());
        existingTask.setDeadline(dtoForm.getDeadline());
        //existingTask.setPerson(findByPersonId());
        Task updatedTask = taskRepository.save(existingTask);
        // Convert to DTO view and return
        return taskConverter.toTaskDTOView(updatedTask);
    }

    @Override
    public void delete(Long id) {
        //Check if task exist by id in repository
        if (!taskRepository.existsById(id)) throw new DataNotFoundException("TaskDTOForm does not exist.");
        //delete task from repository
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDTOView> findByPersonId(Long personId) {
        List<Task> tasks = taskRepository.findByPersonId(personId);

        return tasks.stream().map(taskConverter::toTaskDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTOView> findByDeadlineBetween(LocalDate startDate, LocalDate endDate) {
        List<Task> tasks = taskRepository.findByDeadlineBetween(startDate, endDate);

        return tasks.stream().map(taskConverter::toTaskDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTOView> findByPersonIsNull() {
        List<Task> tasks = taskRepository.findByPersonIsNull();
        return tasks.stream().map(taskConverter::toTaskDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTOView> findUnfinishedAndOverdueTasks() {
        List<Task> tasks = taskRepository.findUnfinishedAndOverdueTasks(LocalDate.now());
        return tasks.stream().map(taskConverter::toTaskDTOView).collect(Collectors.toList());
    }

    @Override
    public TaskDTOView addTaskToPerson(Long personId, TaskDTOForm taskDTOForm) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new DataNotFoundException("Person not found"));
        Task task = taskConverter.toTaskEntity(taskDTOForm);
        task.setPerson(person);
        taskRepository.save(task);
        return taskConverter.toTaskDTOView(task);

    }

}
