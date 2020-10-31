///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package basics;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;

public class Basic_Uni_06 {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("⚡️ Uni from emitter");

    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    CountDownLatch emitterLatch = new CountDownLatch(1);

    Uni<String> uniFromEmitter = Uni.createFrom().emitter(emitter -> {
      forkJoinPool.submit(() -> {
        emitter.complete("Hello");
        emitterLatch.countDown();
      });
    });

    uniFromEmitter.subscribe().with(System.out::println);

    emitterLatch.await();
  }
}
