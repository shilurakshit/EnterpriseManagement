package com.task.controller;

import com.task.DTOs.EmployeeDTO;
import com.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        if(employees.isEmpty()){
            return  new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id){
        EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        return  new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
    }
    @PostMapping(value = "/employees")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        try{
            employeeService.addEmployee(employeeDTO);
            return new ResponseEntity<String>("Employee added successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Employee not added", HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
        try{
            employeeService.updateEmployee(id, employeeDTO);
            return new ResponseEntity<String>("Employee updated successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Employee not updated", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Employee not deleted", HttpStatus.NOT_FOUND);
        }
    }
}
