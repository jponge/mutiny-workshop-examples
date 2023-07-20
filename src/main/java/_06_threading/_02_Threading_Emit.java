///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.3.1
package _06_threading;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.CompletableFuture.delayedExecutor;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class _02_Threading_Emit {

    public static void main(String[] args) {
        System.out.println("⚡️ emitOn (dispatch blocking event processing)");

        var service = Executors.newFixedThreadPool(4);

        Multi.createBy().repeating().uni(() -> generate()).indefinitely()
                .emitOn(service)
                .subscribe().with(item -> System.out.println(Thread.currentThread().getName() + " :: " + item));
    }

    static final AtomicInteger counter = new AtomicInteger();

    static Uni<Integer> generate() {
        return Uni.createFrom().completionStage(
                supplyAsync(counter::getAndIncrement,
                        delayedExecutor(ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS)));
    }
}
