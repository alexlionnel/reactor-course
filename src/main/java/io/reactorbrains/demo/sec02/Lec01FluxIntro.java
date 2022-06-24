package io.reactorbrains.demo.sec02;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux<Integer> fluxEmpty = Flux.empty();

        fluxEmpty.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux<Object> fluxObject = Flux.just(1, 2, 3, Util.faker().name().fullName());

        fluxObject.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
