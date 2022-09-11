package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.*;

// '편결이'
public class ConveniencePayService {
    private final MoneyAdaptor moneyAdaptor = new MoneyAdaptor();
    private final CardAdaptor cardAdaptor = new CardAdaptor();
    private final DiscountInterface discountInterface = new DiscountByPayMethod();

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
        PaymentInterface paymentInterface;

        if(payRequest.getPayMethodType() == PayMethodType.CARD){
            paymentInterface = cardAdaptor;
        } else {
            paymentInterface = moneyAdaptor;
        }

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        if(paymentResult == PaymentResult.PAYMENT_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdaptor;
        } else {
            paymentInterface = moneyAdaptor;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelpayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
