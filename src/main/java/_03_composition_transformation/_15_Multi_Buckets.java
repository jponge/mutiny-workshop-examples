///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.3.1
package _03_composition_transformation;

import io.smallrye.mutiny.Multi;

import java.time.Duration;

public class _15_Multi_Buckets {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚡️ Multi buckets");

        Multi.createFrom()
                .ticks().every(Duration.ofMillis(200))
                .group().intoLists().of(5)
                .subscribe().with(System.out::println);
    }
}
