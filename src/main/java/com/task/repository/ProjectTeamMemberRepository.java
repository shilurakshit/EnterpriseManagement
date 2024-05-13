package com.task.repository;

import com.task.model.ProjectTeamMember;
import com.task.model.ProjectTeamMemberId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTeamMemberRepository extends JpaRepository<ProjectTeamMember, ProjectTeamMemberId> {
    void deleteByProjectId(Integer id);
}
