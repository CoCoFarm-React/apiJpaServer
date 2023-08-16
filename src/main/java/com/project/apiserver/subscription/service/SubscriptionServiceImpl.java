package com.project.apiserver.subscription.service;

import org.springframework.stereotype.Service;

import com.project.apiserver.subscription.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepository;

    @Override
    public void incrementSub(Long fromUser, Long toUser) {

        subRepository.insertSubscriptionNative(fromUser, toUser);
    }

    @Override
    public void deleteSub(Long fromUser, Long toUser) {

        subRepository.deleteSubscriptionNative(fromUser, toUser);
    }

    @Override
    public Long countSub(Long toUser) {
        
        
       return subRepository.countSub(toUser);
    }
    
}
