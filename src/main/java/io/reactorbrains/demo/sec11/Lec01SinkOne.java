package io.reactorbrains.demo.sec11;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {

    public static void main(String[] args) {

        // mono 0 or 1 value
        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("mike"));

        sink.emitValue("hi", ((signalType, emitResult) -> {
            // in case of error
            // return true for retry
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        }));
    }
}
