///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _03_composition;

import static java.util.concurrent.CompletableFuture.delayedExecutor;
import static java.util.concurrent.CompletableFuture.runAsync;

import java.util.concurrent.*;

import io.smallrye.mutiny.Multi;

public class Multi_03 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚡️ Multi transformations to Multi");

        CountDownLatch latch = new CountDownLatch(1);

        Multi.createFrom().range(1, 100)
                .transform().byFilteringItemsWith(n -> n % 2 == 0)
                .transform().byTakingLastItems(5)
                .onItem().transformToMultiAndMerge(n -> query(n))   // try transformToMultiAndConcatenate
                .onItem().transform(n -> "[" + n + "]")
                .onCompletion().invoke(latch::countDown)
                .subscribe().with(System.out::println);

        latch.await();
    }

    static Multi<Integer> query(int n) {
        return Multi.createFrom().emitter(emitter -> {
            runAsync(
                    () -> {
                        emitter.emit(n);
                        emitter.emit(n * 10);
                        emitter.emit(n * 100);
                        emitter.complete();
                    },
                    delayedExecutor(ThreadLocalRandom.current().nextInt(500), TimeUnit.MILLISECONDS));
        });
    }
}
