package yuki.convpay.service;

import yuki.convpay.type.CancelPaymentResult;
import yuki.convpay.type.PayMethodType;
import yuki.convpay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelpayment(Integer cancelPayAmount);

}
