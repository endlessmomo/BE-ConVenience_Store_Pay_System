package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    @Test
    void paySuccess(){
        //given -> 어떤 데이터가 있을 떄
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY ,ConvenienceType.G25, 50);

        //when -> 어떤 경우에
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then -> 결과
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(35, payResponse.getPaidAmount());
    }

    @Test
    void payFail(){
        //given -> 어떤 데이터가 있을 떄
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1500_001);

        //when -> 어떤 경우에
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        //then -> 결과
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPaidAmount());
    }

    @Test
    void pay_cancel_Fail(){
        //given -> 어떤 데이터가 있을 떄
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 99);

        //when -> 어떤 경우에
        PayCancelResponse payCancelResponse= conveniencePayService.payCancel(payCancelRequest);

        //then -> 결과
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL, payCancelResponse.getPayCancelResult());
        assertEquals(0, payCancelResponse.getPayCancelAmount());
    }
    @Test
    void pay_cancel_Success(){
        //given -> 어떤 데이터가 있을 떄
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);

        //when -> 어떤 경우에
        PayCancelResponse payCancelResponse= conveniencePayService.payCancel(payCancelRequest);

        //then -> 결과
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancelResult());
        assertEquals(1000, payCancelResponse.getPayCancelAmount());
    }
}