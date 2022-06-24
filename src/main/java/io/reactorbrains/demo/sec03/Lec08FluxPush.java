package io.reactorbrains.demo.sec03;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        // la méthode push n'est pas threadsafe, on a donc un seul thread qui produit
        Flux.push(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
