package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
