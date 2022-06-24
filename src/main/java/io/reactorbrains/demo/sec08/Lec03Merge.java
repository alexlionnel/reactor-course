package io.reactorbrains.demo.sec08;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec08.helper.AmericanAirlines;
import io.reactorbrains.demo.sec08.helper.Emirates;
import io.reactorbrains.demo.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );
        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
