package com.project.apiserver.subscription.service;

import jakarta.transaction.Transactional;

@Transactional
public interface SubscriptionService {
    
    void incrementSub(Long fromUser, Long toUser);
    void deleteSub(Long fromUser, Long toUser);
    Long countSub(Long toUser);
}
