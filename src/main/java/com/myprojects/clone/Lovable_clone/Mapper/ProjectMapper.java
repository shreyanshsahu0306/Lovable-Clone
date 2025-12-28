package com.myprojects.clone.Lovable_clone.Mapper;

import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectResponse;
import com.myprojects.clone.Lovable_clone.DTOs.project.ProjectSummaryResponse;
import com.myprojects.clone.Lovable_clone.Entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse (Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);
}
