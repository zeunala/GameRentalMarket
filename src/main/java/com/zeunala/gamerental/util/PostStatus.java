package com.zeunala.gamerental.util;

/**
 * 판매글 상태(status) 값으로 사용할 정수값들 모음
 */
public class PostStatus {
    /**
     * 대기물품, 아직 구매자가 등장하지 않은 상태로 언제든지 삭제할 수 있는 상태
     */
    public static final Integer REGISTERING_POST = 0;
    
    /**
     * 거래중 물품, 구매자가 등장하여 거래가 이루어지는 상태
     */
    public static final Integer ACTIVE_DEAL = 1;

    /**
     * 거래종료 물품, 모든 절차를 마치고 거래가 종료된 상태
     */
    public static final Integer CLOSED_DEAL = 2;
}
