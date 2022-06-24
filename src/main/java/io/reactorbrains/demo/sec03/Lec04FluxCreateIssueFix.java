package io.reactorbrains.demo.sec03;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {
        // only one instance of fluxsink
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting : " + country);
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        }).take(3).subscribe(Util.subscriber());
    }
}
