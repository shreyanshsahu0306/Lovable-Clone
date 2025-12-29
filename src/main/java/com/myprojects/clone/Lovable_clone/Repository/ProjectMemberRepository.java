package com.myprojects.clone.Lovable_clone.Repository;

import com.myprojects.clone.Lovable_clone.Entity.ProjectMember;
import com.myprojects.clone.Lovable_clone.Entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);
}
