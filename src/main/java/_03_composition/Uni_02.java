///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _03_composition;

import io.smallrye.mutiny.Uni;

public class Uni_02 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni transform a value with a Uni");

        Uni.createFrom().item(123)
                .onItem().transformToUni(n -> increase(n))
                .onItem().transformToUni((n, emitter) -> emitter.complete("[" + n + "]"))
                .subscribe().with(System.out::println);
    }

    static Uni<Integer> increase(int n) {
        return Uni.createFrom().item(n * 100);
    }
}
