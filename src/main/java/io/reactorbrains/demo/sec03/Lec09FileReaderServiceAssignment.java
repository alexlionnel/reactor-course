package io.reactorbrains.demo.sec03;

import io.reactorbrains.demo.courseutils.Util;
import io.reactorbrains.demo.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        readerService.read(path)
                .take(20)
                .subscribe(Util.subscriber());
    }
}
