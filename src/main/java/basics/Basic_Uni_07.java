///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package basics;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.atomic.AtomicInteger;

public class Basic_Uni_07 {

  public static void main(String[] args) {
    System.out.println("⚡️ Uni from emitter and state");

    Uni<Integer> uniFromEmitterAndState = Uni.createFrom()
      .emitter(AtomicInteger::new, (i, e) -> e.complete(i.addAndGet(10)));

    for (var i = 0; i < 5; i++) {
      uniFromEmitterAndState.subscribe().with(System.out::println);
    }
  }
}
