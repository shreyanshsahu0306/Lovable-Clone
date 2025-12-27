package com.myprojects.clone.Lovable_clone.Service.Impl;

import com.myprojects.clone.Lovable_clone.DTOs.subscription.CheckoutRequest;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.CheckoutResponse;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.PortalResponse;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.SubscriptionResponse;
import com.myprojects.clone.Lovable_clone.Service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
