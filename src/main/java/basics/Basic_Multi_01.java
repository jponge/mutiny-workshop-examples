///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package basics;

import io.smallrye.mutiny.Multi;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic_Multi_01 {

  public static void main(String[] args) {
    System.out.println("⚡️ Hello world");

    Multi.createFrom().items(1, 2, 3)
      .subscribe().with(System.out::println);

    System.out.println("----");

    Multi.createFrom().range(10, 15)
      .subscribe().with(System.out::println);

    var randomNumbers = Stream
      .generate(ThreadLocalRandom.current()::nextInt)
      .limit(5)
      .collect(Collectors.toList());

    System.out.println("----");

    Multi.createFrom().iterable(randomNumbers)
      .subscribe().with(System.out::println);
  }
}
