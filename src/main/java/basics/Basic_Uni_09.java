///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.0
package basics;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.CompletableFuture;

public class Basic_Uni_09 {

  public static void main(String[] args) {
    System.out.println("⚡️ Uni from CompletionStage");

    var cs = new CompletableFuture<String>();

    Uni.createFrom().completionStage(cs)
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

    cs.complete("Ok");
  }
}
