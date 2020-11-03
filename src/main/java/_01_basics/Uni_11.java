///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _01_basics;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import io.smallrye.mutiny.Uni;

import static java.util.concurrent.CompletableFuture.delayedExecutor;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class Uni_11 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni delay");

        Uni.createFrom().item(666)
                .onItem().delayIt().by(Duration.ofSeconds(1))
                .subscribe().with(System.out::println);

        System.out.println("⏰");

        Uni.createFrom().item(666)
                .onItem().delayIt()
                .until(n -> Uni.createFrom().completionStage(
                        supplyAsync(
                                () -> "Ok",
                                delayedExecutor(5, TimeUnit.SECONDS))))
                .subscribe().with(System.out::println);
    }
}
