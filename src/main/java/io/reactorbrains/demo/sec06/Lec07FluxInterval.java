package io.reactorbrains.demo.sec06;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {
        Flux
                .interval(Duration.ofSeconds(1)) // utilise le scheduler parallel en interne
                .subscribe(Util.subscriber());
    }
}
