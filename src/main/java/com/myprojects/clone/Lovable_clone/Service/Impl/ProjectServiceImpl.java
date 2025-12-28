package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectRequest;
import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectResponse;
import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectSummaryResponse;
import com.myprojects.clone.Lovable_clone.Entity.Project;
import com.myprojects.clone.Lovable_clone.Entity.User;
import com.myprojects.clone.Lovable_clone.Mapper.ProjectMapper;
import com.myprojects.clone.Lovable_clone.Repository.ProjectRepository;
import com.myprojects.clone.Lovable_clone.Repository.UserRepository;
import com.myprojects.clone.Lovable_clone.Service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    /*This method returns all the projects which this user is an owner of and also is a member of.*/
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectRepository.findAllAccessibleProjectsByUser(userId)
                .stream()
                .map(project -> projectMapper.toProjectSummaryResponse(project))
                .collect(Collectors.toList());
    }

    /*This method return project having a particular Id that belongs to this user*/
    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProject(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        project = projectRepository.save(project); // this save method is not required as the class in Transactional context so ultimately it will be committed. Just written for best practice
        return projectMapper.toProjectResponse(project);

    }

    /*This method updates the project*/
    @Override
    public ProjectResponse updateProject(Long id, Long userId, ProjectRequest request) {
        Project project = getAccessibleProject(id, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to update the project name.");
        }
        project.setName(request.name());
        project = projectRepository.save(project);// this save method is not required as the class in Transactional context so ultimately it will be committed. Just written for best practice
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProject(id, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to delete this project.");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);// this save method is not required as the class in Transactional context so ultimately it will be committed. Just written for best practice
    }

    /*Helper method*/
    public Project getAccessibleProject(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
