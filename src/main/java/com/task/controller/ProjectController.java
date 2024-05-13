package com.task.controller;

import com.task.DTOs.ProjectDTO;
import com.task.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getAllProject(){
        List<ProjectDTO> projects = projectService.getAllProject();
        if(projects.isEmpty()){
            return  new ResponseEntity<List<ProjectDTO>>(projects, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ProjectDTO>>(projects, HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable int id){
        ProjectDTO projectDTO = projectService.getProject(id);
        return  new ResponseEntity<ProjectDTO>(projectDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/projects")
    public ResponseEntity<String> addProject(@RequestBody ProjectDTO projectDTO){
        try{
            projectService.addProject(projectDTO);
            return new ResponseEntity<String>("Project added successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Project not added", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<String> updateProject(@PathVariable int id, @RequestBody ProjectDTO projectDTO){
        try{
            projectService.updateProject(id,projectDTO);
            return new ResponseEntity<String>("Project updated successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Project not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id){
        try {
            projectService.deleteProject(id);
            return new ResponseEntity<String>("Project deleted successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Project not deleted", HttpStatus.NOT_FOUND);
        }
    }
}