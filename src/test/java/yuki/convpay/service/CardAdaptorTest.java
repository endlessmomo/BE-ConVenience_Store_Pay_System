package yuki.convpay.service;

import yuki.convpay.type.CardUseCancelResult;
import yuki.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdaptorTest {
   private CardAdaptor cardAdaptor = new CardAdaptor();

    @Test
    void capture_success(){
        //given
        Integer payAmount = 100;
        //when
        CardUseResult cardUseResult = cardAdaptor.capture(payAmount);

        //then
        assertEquals(CardUseResult.CARD_USE_SUCCESS, cardUseResult);
    }

    @Test
    void capture_fail(){
        //given
        Integer payAmount = 99;
        //when
        CardUseResult cardUseResult = cardAdaptor.capture(payAmount);

        //then
        assertEquals(CardUseResult.CARD_USE_FAIL, cardUseResult);
    }

    @Test
    void cancelCapture_success(){
        //given
        Integer payAmount = 1001;

        //when
        CardUseCancelResult cardUseCancelResult = cardAdaptor.cancelCapture(payAmount);

        //then
        assertEquals(CardUseCancelResult.CARD_CANCEL_SUCCESS, cardUseCancelResult);
    }

    @Test
    void cancelCapture_fail(){
        //given
        Integer payAmount = 999;

        //when
        CardUseCancelResult cardUseCancelResult = cardAdaptor.cancelCapture(payAmount);

        //then
        assertEquals(CardUseCancelResult.CARD_CANCEL_FAIL, cardUseCancelResult);
    }

}