package com.task.service;

import com.task.model.Employee;
import com.task.DTOs.EmployeeDTO;
import com.task.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    // MAPPER methods
    public Employee dtoToEmployee(EmployeeDTO employeeDTO){
        Employee employee = this.modelMapper.map(employeeDTO,Employee.class);
        return employee;
    }
    public EmployeeDTO  employeeToDto(Employee employee){
        EmployeeDTO employeeDTO = this.modelMapper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }


    // Service methods
    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeDTO> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employees.add(employeeToDto(employee)));
        return employees;
    }
    public EmployeeDTO getEmployee(int id){
        Employee employee = employeeRepository.findById(id).get();
        return employeeToDto(employee);
    }
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = dtoToEmployee(employeeDTO);
        return employeeToDto(employeeRepository.save(employee));
    }


    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setId(id);
        employee.setUpdated_time();
        if(employeeDTO.getName() != null){
            employee.setName(employeeDTO.getName());
        }
        if(employeeDTO.getBirth_date() != null){
            employee.setBirth_date(employeeDTO.getBirth_date());
        }
        if(employeeDTO.getEmail() != null){
            employee.setEmail(employeeDTO.getEmail());
        }
        if(employeeDTO.getDepartment() != null){
            employee.setDepartment(employeeDTO.getDepartment());
        }
        employeeRepository.save(employee);
        return employeeToDto(employee);
    }
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
