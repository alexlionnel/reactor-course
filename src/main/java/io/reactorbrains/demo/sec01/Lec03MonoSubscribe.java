package io.reactorbrains.demo.sec01;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length).map(i -> i / 1);


        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
