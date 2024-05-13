package com.task.service;

import com.task.DTOs.EmployeeDTO;
import com.task.model.Project;
import com.task.DTOs.ProjectDTO;
import com.task.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    @Autowired
//    private ModelMapper modelMapper;

    // MAPPER methods

    public Project dtoToProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setActive(projectDTO.isActive());
        return  project;
    }
    public ProjectDTO  projectToDto(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setActive(project.isActive());
        return  projectDTO;
    }

    // Service methods

    public List<ProjectDTO> getAllProject(){
        List<ProjectDTO> projects = new ArrayList<>();
        projectRepository.findAll().forEach(project -> projects.add(projectToDto(project)));
        return projects;
    }

    public ProjectDTO getProject(int id){
        Project project = projectRepository.findById(id).get();
        return projectToDto(project);
    }

    public void addProject(ProjectDTO projectDTO) {
        Project project = dtoToProject(projectDTO);
        projectToDto(projectRepository.save(project));
    }

    public void updateProject(int id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id).get();
        project.setId(id);
        project.setUpdated_time();
        if(projectDTO.getName() != null){
            project.setName(projectDTO.getName());
        }
        if(projectDTO.getDescription() != null){
            project.setDescription(projectDTO.getDescription());
        }
        project.setActive(projectDTO.isActive());
        projectRepository.save(project);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
