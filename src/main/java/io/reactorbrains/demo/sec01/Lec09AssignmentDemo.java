package io.reactorbrains.demo.sec01;

import io.reactorbrains.demo.sec01.assignment.FileService;
import io.reactorbrains.demo.courseutils.Util;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.write("file03.txt", "This is file3")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
