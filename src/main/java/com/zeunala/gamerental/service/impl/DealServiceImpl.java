package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.Deal;
import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.repository.DealRepository;
import com.zeunala.gamerental.repository.PostRepository;
import com.zeunala.gamerental.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {
    private final PostRepository postRepository;
    private final DealRepository dealRepository;

    @Override
    public DealInfo getDealInfoByDealId(Integer dealId) {
        return dealRepository.findDealInfoByDealId(dealId);
    }

    @Override
    public List<DealInfo> getAllDealInfoBySellerUsersId(Integer sellerUsersId) {
        return dealRepository.findAllDealInfoBySellerUsersId(sellerUsersId);
    }

    @Override
    public List<DealInfo> getAllDealInfoBySellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus) {
        return dealRepository.findAllDealInfoBySellerUsersIdAndPostStatus(sellerUsersId, postStatus);
    }

    @Override
    public List<DealInfo> getAllDealInfoByBuyerUsersId(Integer buyerUsersId) {
        return dealRepository.findAllDealInfoByBuyerUsersId(buyerUsersId);
    }

    @Override
    public List<DealInfo> getAllDealInfoByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus) {
        return dealRepository.findAllDealInfoByBuyerUsersIdAndPostStatus(buyerUsersId, postStatus);
    }

    @Override
    public List<DealInfo> getAllDealInfoByBuyerUsersIdAndDealStatus(Integer buyerUsersId, Integer dealStatus) {
        return dealRepository.findAllDealInfoByBuyerUsersIdAndDealStatus(buyerUsersId, dealStatus);
    }

    @Override
    @Transactional
    public Deal registerDeal(Deal deal) throws IllegalStateException {
        if (postRepository.findPostInfoByPostId(deal.getPostId()).getStatus() == 1) {
            throw new IllegalStateException("이미 거래중인 거래글입니다.");
        }

        postRepository.updateStatusById(deal.getPostId(), 1);
        return dealRepository.save(deal);
    }

    @Override
    public Boolean changeStatusById(Integer id, Integer status) {
        return dealRepository.updateStatusById(id, status);
    }

    @Override
    @Transactional
    public Boolean deleteDealById(Integer id) {
        if (dealRepository.findDealInfoByDealId(id) != null) {
            Integer updateTargetPostId = dealRepository.findDealInfoByDealId(id).getPostId();
            postRepository.updateStatusById(updateTargetPostId, 0);
        }
        return dealRepository.deleteById(id);
    }
}
