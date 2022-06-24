package io.reactorbrains.demo.sec04.helper;

import io.reactorbrains.demo.courseutils.Util;
import lombok.Data;

@Data
public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = Util.faker().name().firstName();
        this.age = Util.faker().random().nextInt(1, 30);
    }
}
