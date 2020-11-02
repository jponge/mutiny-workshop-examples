///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _01_basics;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.delayedExecutor;

public class Uni_09 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚡️ Uni from CompletionStage");

        var cs = CompletableFuture
                .supplyAsync(() -> "Hello!", delayedExecutor(1, TimeUnit.SECONDS))
                .thenApply(String::toUpperCase);

        Uni.createFrom().completionStage(cs)
                .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

        Thread.sleep(2000);
    }
}
