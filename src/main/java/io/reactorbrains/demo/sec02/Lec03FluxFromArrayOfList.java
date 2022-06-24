package io.reactorbrains.demo.sec02;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromArrayOfList {

    public static void main(String[] args) {
        List<String> strings = List.of("a", "b", "c");
        Flux.fromIterable(strings).subscribe(Util.onNext());

        Integer[] arr = {1, 2, 3};
        Flux.fromArray(arr).subscribe(Util.onNext());
    }
}
