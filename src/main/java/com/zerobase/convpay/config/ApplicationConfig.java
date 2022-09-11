package com.zerobase.convpay.config;

import com.zerobase.convpay.service.CardAdaptor;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.service.DiscountByPayMethod;
import com.zerobase.convpay.service.MoneyAdaptor;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {
    public ConveniencePayService conveniencePayServiceDiscountedPayMethod(){
        return new ConveniencePayService(
                new HashSet <>(
                        Arrays.asList(new MoneyAdaptor(), new CardAdaptor())
                ),
                new DiscountByPayMethod()
        );
    }

    public ConveniencePayService conveniencePayServiceDiscountConvenience(){
        return new ConveniencePayService(
                new HashSet <>(
                        Arrays.asList(new MoneyAdaptor(), new CardAdaptor())
                ),
                new DiscountByPayMethod()
        );
    }
}
