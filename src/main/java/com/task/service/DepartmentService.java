package com.task.service;

import com.task.model.Department;
import com.task.DTOs.DepartmentDTO;
import com.task.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    // MAPPER methods
    public Department dtoToDepartment(DepartmentDTO departmentDTO){
        Department department = this.modelMapper.map(departmentDTO,Department.class);
        return department;
    }
    public DepartmentDTO  departmentToDto(Department department){
        DepartmentDTO departmentDTO = this.modelMapper.map(department,DepartmentDTO.class);
        return departmentDTO;
    }


    // Service methods
    public List<DepartmentDTO> getAllDepartment(){
        List<DepartmentDTO> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(department -> departments.add(departmentToDto(department)));
        return departments;
    }

    public DepartmentDTO getDepartment(int id){
        Department department = departmentRepository.findById(id).get();
//        Department department = departmentRepository.findById(id).orElse(null);
        return departmentToDto(department);
    }

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = dtoToDepartment(departmentDTO);
        return departmentToDto(departmentRepository.save(department));
    }
    public String updateDepartment(int id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).get();
        if(departmentDTO.getName()!=null){
            department.setName(departmentDTO.getName());
        }
        if(departmentDTO.getDescription()!=null){
            department.setDescription(departmentDTO.getDescription());
        }
        department.setUpdated_time();
        departmentRepository.save(department);
        return "Department Updated Successfully";
    }
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}