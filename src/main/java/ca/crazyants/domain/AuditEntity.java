package ca.crazyants.domain;

import java.util.*;

abstract class AuditEntity {
    private Date created;
    private Date lastModified;
    private String createdBy;
    private String lastModifiedBy;
}
