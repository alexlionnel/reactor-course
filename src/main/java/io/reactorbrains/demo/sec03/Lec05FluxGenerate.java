package io.reactorbrains.demo.sec03;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {
        // un nombre infini de synchronousSink
        Flux.generate(synchronousSink -> {
            System.out.println("Emitting ");
            synchronousSink.next(Util.faker().country().name());
            synchronousSink.complete();
        })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
