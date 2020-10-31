///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package basics_01;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class Basic_Uni_02 {

  public static void main(String[] args) {
    System.out.println("⚡️ Hello world with UniSubscriber");

    Uni<String> uni = Uni.createFrom().item("Hello, world!");

    uni.subscribe().withSubscriber(new UniSubscriber<String>() {
      @Override
      public void onSubscribe(UniSubscription subscription) {
        System.out.println("onSubscribe");
      }

      @Override
      public void onItem(String item) {
        System.out.println("onItem: " + item);
      }

      @Override
      public void onFailure(Throwable failure) {
        System.out.println("onFailure: " + failure.getMessage());
      }
    });
  }
}
