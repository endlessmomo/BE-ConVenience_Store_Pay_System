package yuki.convpay;

import yuki.convpay.config.ApplicationConfig;
import yuki.convpay.dto.PayCancelRequest;
import yuki.convpay.dto.PayCancelResponse;
import yuki.convpay.dto.PayRequest;
import yuki.convpay.dto.PayResponse;
import yuki.convpay.service.ConveniencePayService;
import yuki.convpay.type.ConvenienceType;
import yuki.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // '사용자' -> 편결이 -> 머니
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ConveniencePayService conveniencePayService = applicationContext.getBean("conveniencePayService",
                ConveniencePayService.class);

        // 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse.toString());

        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println(payCancelResponse.toString());
    }
}
