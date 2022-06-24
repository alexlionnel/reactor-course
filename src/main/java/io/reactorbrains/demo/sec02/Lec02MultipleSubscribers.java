package io.reactorbrains.demo.sec02;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        flux.subscribe(i -> System.out.println("i sub1 = " + i));
        flux.subscribe(i -> System.out.println("i sub2 = " + i));
    }
}
