package io.reactorbrains.demo.sec03;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        // la méthode create est threadsafe
        Flux.create(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
