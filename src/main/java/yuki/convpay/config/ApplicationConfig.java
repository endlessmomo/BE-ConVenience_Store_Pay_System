package yuki.convpay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yuki.convpay.service.CardAdaptor;
import yuki.convpay.service.ConveniencePayService;
import yuki.convpay.service.DiscountByPayMethod;
import yuki.convpay.service.MoneyAdaptor;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {

    @Bean
    public ConveniencePayService conveniencePayService(){
        return new ConveniencePayService(
                new HashSet <>(
                        Arrays.asList( moneyAdaptor(), cardAdaptor())
                ),
                discountByConvenience()
        );
    }

    @Bean
    public static CardAdaptor cardAdaptor() {
        return new CardAdaptor();
    }

    @Bean
    public static MoneyAdaptor moneyAdaptor() {
        return new MoneyAdaptor();
    }

    @Bean
    public static DiscountByPayMethod discountByConvenience() {
        return new DiscountByPayMethod();
    }
}
