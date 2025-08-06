package ca.crazyants.service;

import ca.crazyants.domain.*;
import ca.crazyants.dto.*;
import ca.crazyants.repository.*;
import org.springframework.stereotype.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NodeService {
    private final NodeRepository nodeRepository;
    private final ProjectRepository projectRepository;

    public NodeService(NodeRepository nodeRepository, ProjectRepository projectRepository) {
        this.nodeRepository = nodeRepository;
        this.projectRepository = projectRepository;
    }

    public Node save(NodeDto nodeDto) {
        Node node = new Node();
        node.setName(nodeDto.name());
        
        if (nodeDto.projectId() != null) {
            Project project = projectRepository.findById(nodeDto.projectId())
                    .orElseThrow(() -> new RuntimeException("Project not found with id: " + nodeDto.projectId()));
            node.setProject(project);
        }

        return nodeRepository.save(node);
    }

    public NodeDto findByName(String name) {
        Node node = nodeRepository.findByName(name);
        return node != null ? node.toDto() : null;
    }

    public List<NodeDto> findByProjectId(Long projectId) {
        return nodeRepository.findByProjectId(projectId)
                .stream()
                .map(Node::toDto)
                .collect(Collectors.toList());
    }

    public List<NodeDto> findAll() {
        return nodeRepository.findAll()
                .stream()
                .map(Node::toDto)
                .collect(Collectors.toList());
    }
}