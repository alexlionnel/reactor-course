package io.reactorbrains.demo.sec05;

import io.reactorbrains.demo.courseutils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublishCache {

    public static void main(String[] args) {
        // cache() = publish() + replay()
        Flux<String> movieStream = Flux.fromStream(Lec05HotPublishCache::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .cache(); // le cache sauvegarde les éléments qui ont été publiées

        Util.sleepSeconds(2);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        // conséquence du fonctionnement de cache
        // ce subscriber va directement récupérer les éléments du cache, il n'y aura pas de délais
        // S'il n'y a que 2 éléments dans le cache, alors il ne va récupérer que ces 2 éléments

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
