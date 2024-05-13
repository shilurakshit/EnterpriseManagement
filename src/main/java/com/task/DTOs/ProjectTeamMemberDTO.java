package com.task.DTOs;

import com.task.model.Employee;
import com.task.model.Project;
import com.task.model.ProjectTeamMemberId;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTeamMemberDTO {

    private Project project;
    private Employee employee;
}
