package io.reactorbrains.demo.sec04;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec04.helper.OrderService;
import io.reactorbrains.demo.sec04.helper.UserService;

public class Lec12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
