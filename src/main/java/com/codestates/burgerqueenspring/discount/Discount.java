package com.codestates.burgerqueenspring.discount;

import com.codestates.burgerqueenspring.Cart;
import com.codestates.burgerqueenspring.discount.discountCondition.CozDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.DiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.KidDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedRateDiscountPolicy;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Discount {
    private DiscountCondition[] discountConditions;

//    private static final Logger log = LoggerFactory.getLogger(Discount.class);

    public Discount() {
        this.discountConditions = new DiscountCondition[]{
                new CozDiscountCondition(new FixedRateDiscountPolicy()),
                new KidDiscountCondition(new FixedAmountDiscountPolicy())
        };
    }


    public void checkAllDiscountConditions() {

//        log.info("⭐️ 메서드 호출️ ⭐");
//        log.info("============= 메서드명 = checkAllDiscountConditions =============");
//        log.info("[파라미터] = 없음");

        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
        }
    }

    public int discount(int price) {

//        log.info("⭐️ 메서드 호출️ ⭐");
//        log.info("============= 메서드명 = dicount =============");
//        log.info("[파라미터 타입] = Integer, [파라미터 값] = {}", price);

        int discountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.isSatisfied()) discountedPrice = discountCondition.applyDiscount(discountedPrice);
        }

//        log.info("⭐️ 메서드 호출️ 후 ⭐");
//        log.info("============= 메서드명 = dicount =============");
//        log.info("[반환 값] = {}", discountedPrice);

        return discountedPrice;
    }
}