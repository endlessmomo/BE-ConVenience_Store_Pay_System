package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

import static com.zerobase.convpay.type.MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL;
import static com.zerobase.convpay.type.MoneyUseResult.USE_FAIL;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdaptorTest {
    MoneyAdaptor moneyAdapter = new MoneyAdaptor();

    @Test
    void money_use_fail(){
        //given
        Integer payAmount = 1000_001;
        //when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);
        //then
        assertEquals(USE_FAIL, moneyUseResult);
    }

    @Test
    void money_use_success(){
        //given
        Integer payAmount = 1000_000;
        //when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);
        //then
        assertEquals(USE_FAIL, moneyUseResult);
    }

    @Test
    void money_cancel_fail(){
        //given
        Integer payCancleAmount = 0;

        //when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancleAmount);

        //then
        assertEquals(MONEY_USE_CANCEL_FAIL, moneyUseCancelResult);
    }

}