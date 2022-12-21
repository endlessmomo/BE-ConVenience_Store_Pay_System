package yuki.convpay.service;

import yuki.convpay.type.*;

public class CardAdaptor implements PaymentInterface {
    // 1. 인증
    public void authorization(){
        System.out.println("authorization Success");
    }
    // 2. 승인
    public void approval(){
        System.out.println("approval Success");
    }
    // 3. 매입
    public CardUseResult capture(Integer payAmount){
        if(payAmount < 100){
            return CardUseResult.CARD_USE_FAIL;
        }

        return CardUseResult.CARD_USE_SUCCESS;
    }

    // 4. 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount){
        if(cancelAmount < 1000){
            return CardUseCancelResult.CARD_CANCEL_FAIL;
        }

        return CardUseCancelResult.CARD_CANCEL_SUCCESS;
    }

    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.CARD;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);

        if(cardUseResult == CardUseResult.CARD_USE_FAIL){
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer payCancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(payCancelAmount);

        if(cardUseCancelResult == CardUseCancelResult.CARD_CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }

        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
