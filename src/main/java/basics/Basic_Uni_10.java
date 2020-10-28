package basics;

import io.smallrye.mutiny.Uni;

import java.util.Optional;

public class Basic_Uni_10 {

  public static void main(String[] args) {
    System.out.println("⚡️ Misc");

    Uni.createFrom().nothing()
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

    Uni.createFrom().voidItem()
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

    Uni.createFrom().nullItem()
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

    Uni.createFrom().optional(Optional.of("Hello"))
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

    Uni.createFrom().converter(i -> Uni.createFrom().item("[" + i + "]"), 10)
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

  }
}
