package com.myprojects.clone.Lovable_clone.Entity;

import com.myprojects.clone.Lovable_clone.Enums.ProjectRole;

import java.time.Instant;

public class ProjectMember {

    ProjectMemberId id;

    Project project;

    User user;

    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
