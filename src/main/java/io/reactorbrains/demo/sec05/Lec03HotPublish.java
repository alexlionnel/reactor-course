package io.reactorbrains.demo.sec05;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {

    public static void main(String[] args) {
        // share() = publish() + refCount(1)
        Flux<String> movieStream = Flux.fromStream(Lec03HotPublish::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1); // nombre minimum de subscribers pour envoyer le flux

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        // conséquence du fonctionnement de refCount
        // si le subscriber précédent a fini de lire les données, alors ce subscriber va lire
        // les données depuis ld début (comme un cold publisher)
        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(10);
    }

    //movie theatre
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
