///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _02_groups;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class Uni_02 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚡️ Uni call()");

        CountDownLatch latch = new CountDownLatch(1);

        Uni.createFrom().item(123)
                .onItem().call(n -> asyncLog(">>> ", n))
                .onTermination().call(() -> asyncLog("--- ", ""))
                .subscribe().with(x -> {
                    System.out.println(x);
                    latch.countDown();
                });

        latch.await();
    }

    static Uni<Void> asyncLog(String prefix, Object value) {
        var cs = CompletableFuture
                .runAsync(() -> System.out.println(Thread.currentThread() + " :: " + prefix + value));
        return Uni.createFrom().completionStage(cs);
    }
}
