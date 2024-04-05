package com.codestates.burgerqueenspring.product.subproduct;

import com.codestates.burgerqueenspring.product.Product;

public class Side extends Product {
    private int ketchup;

    public Side(int id, String name, int price, int kcal, int ketchup) {
        super(id, name, price, kcal);
        this.ketchup = ketchup;
    }

    public Side(Side side) {
        super(side.getName(), side.getPrice(), side.getKcal());
        this.ketchup = side.getKetchup();
    }

    public int getKetchup() {
        return ketchup;
    }

    public void setKetchup(int ketchup) {
        this.ketchup = ketchup;
    }
}
