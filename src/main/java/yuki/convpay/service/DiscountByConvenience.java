package yuki.convpay.service;

import yuki.convpay.dto.PayRequest;

public class DiscountByConvenience implements DiscountInterface {

    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch(payRequest.getConvenienceType()) {
            case G25:
                return payRequest.getPayAmount() * 8 / 10;
            case GU:
                return payRequest.getPayAmount() * 9 / 10;
            case SEVEN:
                return payRequest.getPayAmount();
        }
        return payRequest.getPayAmount();
    }
}
