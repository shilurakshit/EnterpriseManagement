package com.task.DTOs;

import com.task.model.Department;
import lombok.*;
import java.time.LocalDate;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private int id;
    private String name;
    private String email;
    private LocalDate birth_date;
    private Department department;
}
