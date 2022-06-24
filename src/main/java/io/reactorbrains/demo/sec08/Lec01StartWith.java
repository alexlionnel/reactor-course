package io.reactorbrains.demo.sec08;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec08.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("jake"));

        generator.generateNames()
                .filter(s -> s.startsWith("A"))
                .take(1)
                .subscribe(Util.subscriber("Marshal"));
    }
}
