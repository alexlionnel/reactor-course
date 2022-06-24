package io.reactorbrains.demo.sec09;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        eventStream()
                .window(Duration.ofSeconds(2))
                .flatMap(flux -> saveEvent(flux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event" + i);
    }

    private static Mono<Integer> saveEvent(Flux<String> fluxString) {
        return fluxString
                .doOnNext(e -> System.out.println("saving " + e))
                .doOnComplete(() -> {
                    System.out.println("saving this batch");
                    System.out.println("-----------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}
