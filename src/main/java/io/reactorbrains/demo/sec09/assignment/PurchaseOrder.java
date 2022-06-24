package io.reactorbrains.demo.sec09.assignment;

import io.reactorbrains.demo.courseutils.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price().replace(",", "."));
        this.category = Util.faker().commerce().department();
    }
}
