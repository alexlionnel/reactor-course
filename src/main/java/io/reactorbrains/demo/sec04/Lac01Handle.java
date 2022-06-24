package io.reactorbrains.demo.sec04;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lac01Handle {

    public static void main(String[] args) {
        // handle = filter + map
        Flux.range(1, 25).handle((integer, synchronousSink) -> {
            if (integer % 2 == 0) {
                synchronousSink.next(integer);
            }
        }).subscribe(Util.subscriber());
    }
}
