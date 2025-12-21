package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectRequest;
import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectResponse;
import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, Long userId, ProjectRequest request);

    void softDelete(Long id, Long userId);
}
