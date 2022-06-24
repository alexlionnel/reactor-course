package io.reactorbrains.demo.sec02;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");

        Flux.from(mono).subscribe(Util.onNext()); // conversion du mono en flux

        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // conversion du flux en mono
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
