///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.0.0
package _06_threading;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.BlockingIterable;
import io.smallrye.mutiny.infrastructure.Infrastructure;

import java.util.stream.Collectors;

public class _05_Threading_Blocking_Check {

    public static void main(String[] args) {
        System.out.println("⚡️ blocking");

        Infrastructure.setCanCallerThreadBeBlockedSupplier(() -> !Thread.currentThread().getName().contains("yolo"));

        new Thread(() -> {
            BlockingIterable<Integer> iterable = Multi.createFrom().range(0, 10)
                    .subscribe().asIterable();

            var list = iterable.stream().collect(Collectors.toList());

            System.out.println(list);
        }, "yolo-1").start();

        new Thread(() -> {
            Integer someInt = Uni.createFrom().item(123)
                    .await().indefinitely();

            System.out.println(someInt);
        }, "yolo-2").start();
    }
}
