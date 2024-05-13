package com.task.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@Embeddable // important
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode // important
public class ProjectTeamMemberId implements Serializable {

    private Project project;
    private Employee employee;
}
