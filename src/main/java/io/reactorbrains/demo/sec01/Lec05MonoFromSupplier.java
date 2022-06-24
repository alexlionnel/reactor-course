package io.reactorbrains.demo.sec01;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {
        // use just only we have data already
        // Mono.just(getName());
        Supplier<String> stringSupplier = () -> getName();
        Mono.fromSupplier(stringSupplier).subscribe(Util.onNext());

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable).subscribe(Util.onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
