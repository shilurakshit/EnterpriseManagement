package com.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Department")
@NoArgsConstructor
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "name")
    @Setter
    private String name;

    @JoinColumn(name = "description")
    @Setter
    private String description;

    @JoinColumn(name = "created_time", updatable = false)
    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime created_time;

    @JoinColumn(name = "updated_time")
    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updated_time;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<Employee> employees;
    public Department(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public void setUpdated_time() {
        this.updated_time = LocalDateTime.now();
    }
}
