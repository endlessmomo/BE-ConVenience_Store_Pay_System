package yuki.convpay.service;

import yuki.convpay.dto.PayRequest;
import yuki.convpay.type.ConvenienceType;
import yuki.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountAmount(){
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.G25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G25, 1000);

        //when
        Integer discountedAmountMoney = discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCard = discountByPayMethod.getDiscountedAmount(payRequestCard);

        //then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000, discountedAmountCard);
    }

}