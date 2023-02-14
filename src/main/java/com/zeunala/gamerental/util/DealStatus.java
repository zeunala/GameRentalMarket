package com.zeunala.gamerental.util;

/**
 * 거래글 상태(status) 값으로 사용할 정수값들 모음
 */
public class DealStatus {
    /**
     * 입금대기/거래전, 아직 구매자가 돈을 입금하지 않은 상태
     */
    public static final Integer BEFORE_DEAL = 0;
    
    /**
     * 구매자입금, 구매자가 돈을 입금한 상태 (택배거래시에만 존재)
     */
    public static final Integer AFTER_WIRE_MONEY = 1;

    /**
     * 렌탈중, 구매자가 물건을 받아 사용하는 상태 (렌탈거래시에만 존재)
     */
    public static final Integer IN_RENTAL = 2;

    /**
     * 판매자 반환수령 및 보증금 입금, 구매자에게 최초 보증금을 돌려주어야 하는 상태 (보증금이 있는 렌탈거래시에만 존재)
     */
    public static final Integer DEPOSIT_REMAIN = 3;

    /**
     * 거래종료, 든 절차를 마치고 거래가 종료된 상태
     */
    public static final Integer AFTER_DEAL = 4;
}
