///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _03_composition;

import io.smallrye.mutiny.Multi;

public class Multi_01 {

    public static void main(String[] args) {
        System.out.println("⚡️ Multi transformations");

        Multi.createFrom().range(1, 100)
                .transform().byFilteringItemsWith(n -> n % 2 == 0)
                .transform().byTakingLastItems(5)
                .onItem().transform(n -> "[" + n + "]")
                .subscribe().with(System.out::println);
    }
}