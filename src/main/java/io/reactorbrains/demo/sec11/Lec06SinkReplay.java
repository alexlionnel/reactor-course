package io.reactorbrains.demo.sec11;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec06SinkReplay {

    public static void main(String[] args) {
        // handle through which we would push items
        // replay -> rejouer l'historique quand un nouveau subscriber arrive
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));

        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("jake"));

    }
}
