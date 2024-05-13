package com.task.controller;

import com.task.DTOs.DepartmentDTO;
import com.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> departments = departmentService.getAllDepartment();
        if(departments.isEmpty()){
            return  new ResponseEntity<List<DepartmentDTO>>(departments, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<DepartmentDTO>>(departments, HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable int id){
        DepartmentDTO departmentDTO = departmentService.getDepartment(id);
        return  new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/departments")
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDTO departmentDTO){
        try{
            departmentService.addDepartment(departmentDTO);
            return new ResponseEntity<String>("Department added successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Department not added", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/departments/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable int id, @RequestBody DepartmentDTO departmentDTO){
        String status = departmentService.updateDepartment(id, departmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @DeleteMapping(value = "/departments/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id){
        try {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<String>("Department deleted successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Department not deleted", HttpStatus.NOT_FOUND);
        }
    }
}
