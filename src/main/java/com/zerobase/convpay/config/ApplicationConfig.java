package com.zerobase.convpay.config;

import com.zerobase.convpay.service.CardAdaptor;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.service.DiscountByPayMethod;
import com.zerobase.convpay.service.MoneyAdaptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {

    @Bean
    public ConveniencePayService conveniencePayService(){
        return new ConveniencePayService(
                new HashSet <>(
                        Arrays.asList( MoneyAdaptor(), CardAdaptor())
                ),
                discountByConvenience()
        );
    }

    @Bean
    public static CardAdaptor CardAdaptor() {
        return new CardAdaptor();
    }

    @Bean
    public static MoneyAdaptor MoneyAdaptor() {
        return new MoneyAdaptor();
    }

    @Bean
    public static DiscountByPayMethod discountByConvenience() {
        return new DiscountByPayMethod();
    }
}
