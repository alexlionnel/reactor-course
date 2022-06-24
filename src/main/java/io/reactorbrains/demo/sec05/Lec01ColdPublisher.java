package io.reactorbrains.demo.sec05;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {

    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(Lec01ColdPublisher::getMovie)
                .delayElements(Duration.ofSeconds(2));

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(5);
    }

    //netflix
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
