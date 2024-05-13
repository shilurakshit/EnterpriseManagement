package com.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Project")
@Getter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    @Setter
    private int id;

    @JoinColumn(name = "name")
    @Setter
    private String name;

    @JoinColumn(name = "description")
    @Setter
    private String description;

    @JoinColumn(name = "is_active")
    @Setter
    private boolean isActive;


    @JoinColumn(name = "created_time", updatable = false)
    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime created_time = LocalDateTime.now();

    @JoinColumn(name = "updated_time")
    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updated_time;

//    @OneToMany(mappedBy = "project", cascade = CascadeType.MERGE)
//    private List<ProjectTeamMember> projectTeamMembers;

    public Project(String name, String description, boolean isActive){
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }
    public void setUpdated_time() {
        this.updated_time = LocalDateTime.now();
    }

}
