package se.lexicon.g49todoapi.service;

import se.lexicon.g49todoapi.domanin.dto.TaskDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;
import se.lexicon.g49todoapi.domanin.entity.Task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TaskService {
    // create
    TaskDTOView create(TaskDTOForm dtoForm);
    // findById
    TaskDTOView findById(Long id);
    // update
    TaskDTOView update(TaskDTOForm dtoForm);
    // delete
    void delete(Long id);
    // findTasksByPersonId
    List<TaskDTOView> findByPersonId(Long personId);
    // findTasksBetweenStartAndEndDate
    List<TaskDTOView> findByDeadlineBetween(LocalDate startDate, LocalDate endDate);
    // findAllUnassignedTasks
    List<TaskDTOView> findByPersonIsNull();
    //findAllUnfinishedTasksAndOverdue
    List<TaskDTOView> findUnfinishedAndOverdueTasks();
    TaskDTOView addTaskToPerson(Long personId, TaskDTOForm taskDTOForm);
}
