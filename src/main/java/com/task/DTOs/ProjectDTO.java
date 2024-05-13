package com.task.DTOs;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private int id;
    private String name;
    private String description;
    private boolean isActive;
}
