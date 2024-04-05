package com.codestates.burgerqueenspring.discount.discountPolicy;


public class FixedRateDiscountPolicy implements DiscountPolicy {

    private int discountRate = 10;

    public int calculateDiscountedPrice(int price) {
        return price - (price * discountRate / 100);
    }
}
