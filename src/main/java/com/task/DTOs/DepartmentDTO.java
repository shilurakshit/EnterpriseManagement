package com.task.DTOs;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private int id;
    private String name;
    private String description;
}
