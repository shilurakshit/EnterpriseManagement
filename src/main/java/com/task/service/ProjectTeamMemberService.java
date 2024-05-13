package com.task.service;

import com.task.DTOs.ProjectTeamMemberDTO;
import com.task.model.Employee;
import com.task.model.Project;
import com.task.model.ProjectTeamMember;
import com.task.repository.EmployeeRepository;
import com.task.repository.ProjectRepository;
import com.task.repository.ProjectTeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectTeamMemberService {
    @Autowired
    private ProjectTeamMemberRepository projectTeamMemberRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<ProjectTeamMemberDTO> getAllProjectTeamMembers() {
        List<ProjectTeamMemberDTO> projectTeamMembers = new ArrayList<>();
        projectTeamMemberRepository.findAll().forEach(projectTeamMember -> projectTeamMembers.add(projectTeamMemberToDTO(projectTeamMember)));
        return projectTeamMembers;
    }

    public String addProjectTeamMember(ProjectTeamMemberDTO projectTeamMemberDTO) {
        Optional<Employee> employee = employeeRepository.findById(projectTeamMemberDTO.getEmployee().getId());
        Optional<Project> project = projectRepository.findById(projectTeamMemberDTO.getProject().getId());
        ProjectTeamMember result = dtoToProjectTeamMember(projectTeamMemberDTO);


        if(employee.isPresent() && project.isPresent()){
            projectTeamMemberRepository.save(result);
            return "Data Added successfully";
        }else {
            return null;
        }

//        Employee employee = employeeRepository.findById(projectTeamMemberDTO.getEmployee().getId()).get();
//        Project project = projectRepository.findById(projectTeamMemberDTO.getProject().getId()).get();
//        ProjectTeamMember result = new ProjectTeamMember(project, employee);
//        projectTeamMemberRepository.save(result);
//        return "Data Added successfully";
    }
    public String deleteProjectTeamMember(int id) {
        projectTeamMemberRepository.deleteByProjectId(id);
        return "Data Deleted successfully";
    }

    // Mapper methods
    public ProjectTeamMember dtoToProjectTeamMember(ProjectTeamMemberDTO projectTeamMemberDTO) {
        ProjectTeamMember projectTeamMember = new ProjectTeamMember();
        projectTeamMember.setEmployee(projectTeamMemberDTO.getEmployee());
        projectTeamMember.setProject(projectTeamMemberDTO.getProject());
        return projectTeamMember;
    }
    public ProjectTeamMemberDTO projectTeamMemberToDTO(ProjectTeamMember projectTeamMember) {
        ProjectTeamMemberDTO projectTeamMemberDTO = new ProjectTeamMemberDTO();
        projectTeamMemberDTO.setEmployee(projectTeamMember.getEmployee());
        projectTeamMemberDTO.setProject(projectTeamMember.getProject());
        return projectTeamMemberDTO;
    }
}
