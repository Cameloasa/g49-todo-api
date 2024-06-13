package se.lexicon.g49todoapi.converter;

import se.lexicon.g49todoapi.domanin.dto.TaskDTOForm;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;
import se.lexicon.g49todoapi.domanin.entity.Task;

public interface TaskConverter {

    TaskDTOView toTaskDTOView(Task entity);
    Task toTaskEntity(TaskDTOForm dtoForm);
}
