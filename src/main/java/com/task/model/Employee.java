package com.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Entity
@Table(name = "Employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "name")
    @Setter
    private String name;

    @JoinColumn(name = "email")
    @Setter
    private String email;

    @JoinColumn(name = "birth_date")
    @Setter
    private LocalDate birth_date;

    @CreationTimestamp
    @JoinColumn(name = "created_time", updatable = false)
    @JsonIgnore
    private LocalDateTime created_time = LocalDateTime.now();

    @UpdateTimestamp
    @JoinColumn(name = "updated_time")
    @JsonIgnore
    private LocalDateTime updated_time;

//    @ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @Setter
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private List<ProjectTeamMember> projectTeamMembers;

    public void setUpdated_time() {
        this.updated_time = LocalDateTime.now();
    }



}
