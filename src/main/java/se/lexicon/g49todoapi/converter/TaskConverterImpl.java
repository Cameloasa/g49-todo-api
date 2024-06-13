package se.lexicon.g49todoapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.g49todoapi.domanin.dto.TaskDTOView;
import se.lexicon.g49todoapi.domanin.entity.Task;

@Component
public class TaskConverterImpl implements TaskConverter {
    @Override
    public TaskDTOView toTaskDTO(Task entity) {

        return TaskDTOView.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .person(entity.getPerson())
                .build();
    }

    @Override
    public Task toTaskEntity(TaskDTOView dto) {
        return Task.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .person(dto.getPerson())
                .build();
    }
}
