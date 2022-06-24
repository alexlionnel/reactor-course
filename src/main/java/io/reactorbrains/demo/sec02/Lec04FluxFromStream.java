package io.reactorbrains.demo.sec02;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        Flux<Integer> flux = Flux.fromStream(list::stream);
        flux.subscribe(Util.onNext());
        flux.subscribe(Util.onNext());

        Flux<Integer> flux2 = Flux.fromStream(stream);
        flux2.subscribe(Util.onNext());
        flux2.subscribe(Util.onNext());
    }
}
