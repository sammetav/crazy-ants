package ca.crazyants.repository;

import ca.crazyants.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.List;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
    Node findByName(String name);
    List<Node> findByProjectId(Long projectId);
}