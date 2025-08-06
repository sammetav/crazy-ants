package ca.crazyants.domain;

import ca.crazyants.dto.*;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "node")
public class Node extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private List<Node> children;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public NodeDto toDto() {
        Long projectId = this.project != null ? this.project.getId() : null;
        return new NodeDto(this.name, projectId);
    }
}
