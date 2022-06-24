package io.reactorbrains.demo.sec01;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        // on utilise un mono de runnable quand on veut être notifiée lorsqu'une opération longue est terminée
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> System.out.println("Process is done, sending emails..."));


    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
