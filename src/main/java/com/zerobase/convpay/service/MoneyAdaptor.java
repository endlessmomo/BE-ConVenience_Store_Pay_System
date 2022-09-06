package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;

public class MoneyAdaptor {
    public MoneyUseResult use(Integer payAmount) {
        System.out.println("MoneyAdaptor.use : " + payAmount);

        if (payAmount > 1000_000) {
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancelResult useCancle(Integer payCancelAmount) {
        System.out.println("MoneyAdaptor.useCancle : " + payCancelAmount);

        if (payCancelAmount < 100) {
            return MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL;
        } else {
            return MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS;
        }

    }
}
