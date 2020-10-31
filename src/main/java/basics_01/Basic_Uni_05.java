///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package basics_01;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.atomic.AtomicLong;

public class Basic_Uni_05 {

  public static void main(String[] args) {
    System.out.println("️⚡️ Deferred Uni");

    AtomicLong ids = new AtomicLong();

    Uni<Long> deferredUni = Uni.createFrom().deferred(() -> Uni.createFrom().item(ids::incrementAndGet));

    for (var i = 0; i < 5; i++) {
      deferredUni.subscribe().with(System.out::println);
    }
  }
}
