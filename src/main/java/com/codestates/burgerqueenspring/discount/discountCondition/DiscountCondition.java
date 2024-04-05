package com.codestates.burgerqueenspring.discount.discountCondition;

public interface DiscountCondition {
    void checkDiscountCondition();
    int applyDiscount(int price);
    boolean isSatisfied();
}