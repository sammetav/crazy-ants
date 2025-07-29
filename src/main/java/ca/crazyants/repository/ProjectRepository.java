package ca.crazyants.repository;

import ca.crazyants.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByKey(String key);
}
