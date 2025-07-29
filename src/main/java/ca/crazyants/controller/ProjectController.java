package ca.crazyants.controller;

import ca.crazyants.domain.*;
import ca.crazyants.dto.*;
import ca.crazyants.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/projects")
public class ProjectController {
    public final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    Project saveProject(@RequestBody ProjectDto projectDto) {
        return projectService.save(projectDto);
    }

    @GetMapping("{key}")
    ProjectDto findProjectByKey(@PathVariable String key) {
        return projectService.findByKey(key);
    }
}
