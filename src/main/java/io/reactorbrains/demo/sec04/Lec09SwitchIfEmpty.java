package io.reactorbrains.demo.sec04;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback()) // publisher fallback si aucune valeur dans le flux
                .subscribe(Util.subscriber());
    }

    // redis cache for example
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    // database for example
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }
}
