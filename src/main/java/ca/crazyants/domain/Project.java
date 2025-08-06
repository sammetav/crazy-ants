package ca.crazyants.domain;


import ca.crazyants.dto.*;
import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String key;

    @Column
    private String name;

    @Column
    private String description;


    public Project() {
    }

    public Project(String name, String key, String description) {
        this.name = name;
        this.key = key;
        this.description = description;
    }

    public Project setKey(String key) {
        this.key = key;
        return this;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProjectDto toDto() {
        ProjectDto projectDto = new ProjectDto(this.key, this.name, this.description);
        return projectDto;
    }
}
