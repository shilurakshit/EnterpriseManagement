package com.task.repository;

import com.task.model.Department;
import com.task.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer>, JpaRepository<Project,Integer> {

}
