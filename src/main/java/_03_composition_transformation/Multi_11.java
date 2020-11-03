///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _03_composition_transformation;

import java.time.Duration;

import io.smallrye.mutiny.Multi;

public class Multi_11 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚡️ Multi temporal buckets");

        Multi.createFrom()
                .ticks().every(Duration.ofMillis(200))
                .groupItems().intoLists().every(Duration.ofSeconds(2))
                .subscribe().with(System.out::println);
    }
}