package io.reactorbrains.demo.sec02;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        // rien ne sera affiché avant l'écoulement du temps
        System.out.println(names);

        NameGenerator.getNamesFlux(5).subscribe(Util.onNext());

    }
}
