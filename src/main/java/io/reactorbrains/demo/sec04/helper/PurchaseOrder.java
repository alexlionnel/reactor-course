package io.reactorbrains.demo.sec04.helper;

import io.reactorbrains.demo.courseutils.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.price = Util.faker().commerce().price();
        this.item = Util.faker().commerce().productName();
    }
}
