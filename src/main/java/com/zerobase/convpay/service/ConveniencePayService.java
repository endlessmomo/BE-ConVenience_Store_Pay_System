package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;

public class ConveniencePayService {
    private final MoneyAdaptor moneyAdaptor = new MoneyAdaptor();
 /*
    해당 순서로 구현하는게 가장 Best!

    // fail fast

    // Method()

    // Exception case 1
    // Exception case 2
    // Exception case 3

    // Success Case (Only One)
*/
    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult =
                moneyAdaptor.use(payRequest.getPayAmount());
        if(moneyUseResult == MoneyUseResult.USE_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        } else{
            return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
        }
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancleRequest) {
        MoneyUseCancelResult moneyUseCancelResult = moneyAdaptor.useCancle(
                payCancleRequest.getPayCancelAmount());

        if(moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success code
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancleRequest.getPayCancelAmount());
    }
}
