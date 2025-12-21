package com.myprojects.clone.Lovable_clone.Service;

import com.myprojects.clone.Lovable_clone.DTOs.subscription.CheckoutRequest;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.CheckoutResponse;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.PortalResponse;
import com.myprojects.clone.Lovable_clone.DTOs.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
