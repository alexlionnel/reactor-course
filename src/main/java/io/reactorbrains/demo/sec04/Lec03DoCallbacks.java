package io.reactorbrains.demo.sec04;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
            //fluxSink.error(new RuntimeException("oops"));
            System.out.println("--completed");
        })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(i -> System.out.println("doOnNext : " + i))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 : " + s))
                .doOnRequest(l -> System.out.println("doOnRequest : " + l))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnError(e -> System.out.println("doOnError : " + e.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 : " + s))
                .doFirst(() -> System.out.println("doFirst 3"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
                .take(2)
                .doFinally(signal -> System.out.println("doFinally : " + signal))
                .subscribe(Util.subscriber());
    }
}
