package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.domain.Deal;
import com.zeunala.gamerental.domain.Post;
import com.zeunala.gamerental.domain.Users;
import com.zeunala.gamerental.dto.DealDto;
import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.repository.DealRepository;
import com.zeunala.gamerental.repository.jpa.SpringDataJpaDealRepository;
import com.zeunala.gamerental.util.DealStatus;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
@Transactional
@RequiredArgsConstructor
public class JpaDealRepository implements DealRepository {
    private final SpringDataJpaDealRepository repository;
    private final EntityManager em;

    @Override
    public DealInfo findDealInfoByDealId(Integer dealId) {
        return repository.findById(dealId).map(DealInfo::new).orElse(null);
    }

    @Override
    public List<DealInfo> findAllDealInfoBySellerUsersId(Integer sellerUsersId) {
        return repository.findByPostSellerUsersId(sellerUsersId)
                .stream().map(DealInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<DealInfo> findAllDealInfoBySellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus) {
        return repository.findByPostSellerUsersIdAndPostStatus(sellerUsersId, postStatus)
                .stream().map(DealInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<DealInfo> findAllDealInfoByBuyerUsersId(Integer buyerUsersId) {
        return repository.findByBuyerUsersId(buyerUsersId)
                .stream().map(DealInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<DealInfo> findAllDealInfoByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus) {
        return repository.findByBuyerUsersIdAndPostStatus(buyerUsersId, postStatus)
                .stream().map(DealInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<DealInfo> findAllDealInfoByBuyerUsersIdAndDealStatus(Integer buyerUsersId, Integer dealStatus) {
        return repository.findByBuyerUsersIdAndStatus(buyerUsersId, dealStatus)
                .stream().map(DealInfo::new).collect(Collectors.toList());
    }

    @Override
    public DealDto save(DealDto dealDto) {
        Deal deal = new Deal(null,
                em.find(Post.class, dealDto.getPostId()),
                em.find(Users.class, dealDto.getBuyerUsersId()),
                dealDto.getTotalPrice(),
                LocalDateTime.now(),
                DealStatus.BEFORE_DEAL,
                null);
        DealDto result = new DealDto(repository.save(deal));
        return result;
    }

    @Override
    public Boolean updateStatusById(Integer id, Integer status) {
        Deal deal = em.find(Deal.class, id);
        if (deal == null) {
            return false;
        }

        deal.setStatus(status);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
