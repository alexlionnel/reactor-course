package io.reactorbrains.demo.sec04;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {

    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 0) // nombre demandé et pourcentage au dela duquel on demande de nouveau un pourcentage de données
                .subscribe(Util.subscriber());
    }
}
