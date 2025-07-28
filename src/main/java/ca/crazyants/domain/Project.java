package ca.crazyants.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String key;

    @Column
    private String description;
}
