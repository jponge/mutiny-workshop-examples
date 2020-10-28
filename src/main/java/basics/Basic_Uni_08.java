package basics;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

public class Basic_Uni_08 {

  public static void main(String[] args) {
    System.out.println("⚡️ Uni from failure");

    Uni.createFrom().failure(new IOException("Boom"))
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

    Uni.createFrom().failure(() -> new IOException("Badaboom"))
      .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));
  }
}
