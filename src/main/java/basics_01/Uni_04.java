///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package basics_01;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.atomic.AtomicInteger;

public class Uni_04 {

  public static void main(String[] args) {
    System.out.println("️⚡️ Uni from supplier with state");

    Uni<Integer> uniFromSupplierAndState = Uni.createFrom().item(AtomicInteger::new, i -> i.addAndGet(10));

    for (var i = 0; i < 5; i++) {
      uniFromSupplierAndState.subscribe().with(System.out::println);
    }
  }
}
