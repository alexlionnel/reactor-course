package io.reactorbrains.demo.sec01;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        String result = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(result);
        getName();

        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("Enter get name method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
