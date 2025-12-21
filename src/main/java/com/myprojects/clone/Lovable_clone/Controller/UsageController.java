package com.myprojects.clone.Lovable_clone.Controller;

import com.myprojects.clone.Lovable_clone.DTOs.subscription.PlanLimitsResponse;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.UsageTodayResponse;
import com.myprojects.clone.Lovable_clone.Service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodaysUsage(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getTodaysUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponse> getPlansLimits(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }
}
