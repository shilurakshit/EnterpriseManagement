package com.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "Project_team_member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(ProjectTeamMemberId.class) //important
public class ProjectTeamMember {

    @Id
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
