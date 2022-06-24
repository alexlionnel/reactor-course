package io.reactorbrains.demo.sec03;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(
                () -> 1, // état initial
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if(counter >= 10 || country.equalsIgnoreCase("canada")) {
                        sink.complete();
                    }
                    return counter + 1;
                }
        ).subscribe(Util.subscriber());
    }
}
