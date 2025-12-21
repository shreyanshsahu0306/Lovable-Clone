package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.project.FileContentResponse;
import com.myprojects.clone.Lovable_clone.DTOs.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
