package io.reactorbrains.demo.sec07;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec03Latest {

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed " + i);
                        Util.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
