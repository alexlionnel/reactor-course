package io.reactorbrains.demo.sec08;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");
        Flux<Object> flux3 = Flux.error(new RuntimeException("oops"));

        flux1.concatWith(flux2).subscribe(Util.subscriber());

        Flux.concat(flux1, flux3, flux2).subscribe(Util.subscriber());
        Flux.concatDelayError(flux1, flux3, flux2).subscribe(Util.subscriber());
    }
}
