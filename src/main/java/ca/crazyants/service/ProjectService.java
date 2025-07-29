package ca.crazyants.service;

import ca.crazyants.domain.*;
import ca.crazyants.dto.*;
import ca.crazyants.repository.*;
import org.springframework.stereotype.*;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(ProjectDto projectDto) {
        Project project = new Project()
                .setKey(projectDto.key())
                .setName(projectDto.name())
                .setDescription(projectDto.description());

        return projectRepository.save(project);
    }

    public ProjectDto findByKey(String key) {
        return projectRepository.findByKey(key).toDto();
    }
}


