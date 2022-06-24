package io.reactorbrains.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Lec03SVRangeTest {

    @Test
    void test1() {
        Flux<Integer> range = Flux.range(1, 50);

        StepVerifier.create(range)
                .expectNextCount(50)
                .verifyComplete();
    }

    @Test
    void test2() {
        Flux<Integer> range = Flux.range(1, 50);

        StepVerifier.create(range)
                .thenConsumeWhile(i -> i < 100) // parfois on ne connait pas le nombre d'éléments du flux, mais on connait comment sont les éléments du flux
                .verifyComplete();
    }
}
