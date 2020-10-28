package basics;

import io.smallrye.mutiny.Uni;

public class Basic_Uni_01 {

  public static void main(String[] args) {
    System.out.println("⚡️ Hello world");

    Uni<String> uni = Uni.createFrom().item("Hello, world!");

    uni.subscribe().with(System.out::println);
  }
}
