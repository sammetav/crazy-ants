package ca.crazyants.controller;

import ca.crazyants.domain.*;
import ca.crazyants.dto.*;
import ca.crazyants.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/nodes")
public class NodeController {
    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @PostMapping
    Node saveNode(@RequestBody NodeDto nodeDto) {
        return nodeService.save(nodeDto);
    }

    @GetMapping("/{name}")
    NodeDto findNodeByName(@PathVariable String name) {
        return nodeService.findByName(name);
    }

    @GetMapping
    List<NodeDto> findAllNodes() {
        return nodeService.findAll();
    }

    @GetMapping("project/{projectId}")
    List<NodeDto> findNodesByProjectId(@PathVariable Long projectId) {
        return nodeService.findByProjectId(projectId);
    }
}