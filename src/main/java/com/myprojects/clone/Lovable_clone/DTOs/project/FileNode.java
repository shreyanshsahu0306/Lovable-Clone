package com.myprojects.clone.Lovable_clone.DTOs.project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        Long size,
        String type
) {
}
