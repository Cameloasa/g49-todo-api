package se.lexicon.g49todoapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public TaskDTOView create(TaskDTOForm dtoForm) {
        return null;
    }

    @Override
    public TaskDTOView findById(Long id) {
        return null;
    }

    @Override
    public TaskDTOView update(TaskDTOForm dtoForm) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TaskDTOView> findByPersonId(Long personId) {
        return List.of();
    }

    @Override
    public List<TaskDTOView> findByDeadlineBetween(LocalDate startDate, LocalDate endDate) {
        return List.of();
    }

    @Override
    public List<TaskDTOView> findByPersonIsNull() {
        return List.of();
    }

    @Override
    public List<TaskDTOView> findUnfinishedAndOverdueTasks() {
        return List.of();
    }
}
