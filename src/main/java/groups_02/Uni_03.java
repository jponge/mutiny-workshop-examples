///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package groups_02;

import io.smallrye.mutiny.Uni;

public class Uni_03 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni invoke / call shortcuts");

        Uni.createFrom().item(123)
                .invoke(n -> System.out.println("n = " + n))
                .call(n -> Uni.createFrom()
                        .voidItem()
                        .invoke(() -> System.out.println("call(" + n + ")")))
                .eventually(() -> System.out.println("eventually()"))
                .subscribe().with(System.out::println);

    }
}
