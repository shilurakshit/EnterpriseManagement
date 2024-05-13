package com.task.controller;

import com.task.DTOs.ProjectTeamMemberDTO;
import com.task.model.ProjectTeamMember;
import com.task.model.ProjectTeamMemberId;
import com.task.service.ProjectTeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectTeamMemberController {
    @Autowired
    private ProjectTeamMemberService projectTeamMemberService;

    @GetMapping("/project_teams")
    public ResponseEntity<List<ProjectTeamMemberDTO>> getAllProjectTeamMembers() {
        List<ProjectTeamMemberDTO> teamMembers = projectTeamMemberService.getAllProjectTeamMembers();

        if(teamMembers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(teamMembers);
        }
    }
    @PostMapping("/project_teams")
    public ResponseEntity<String> addProjectTeamMember(@RequestBody ProjectTeamMemberDTO projectTeamMemberDTO) {
        String status = projectTeamMemberService.addProjectTeamMember(projectTeamMemberDTO);
        if(status.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }
    }

    @DeleteMapping("/project_teams/{id}")
    public ResponseEntity<String> deleteProjectTeamMember(@PathVariable int id) {
        String status = projectTeamMemberService.deleteProjectTeamMember(id);
        return  ResponseEntity.status(HttpStatus.OK).body(status);
    }
}
