///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _03_composition_transformation;

import io.smallrye.mutiny.Multi;

public class Multi_12 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("⚡️ Multi disjoint items");

        Multi.createFrom().range(0, 10)
                .onItem().transformToMultiAndMerge(n -> Multi.createFrom().items(n, n * 2, n, n * 5, n, n * 10))
                .groupItems().intoLists().of(3)
                .onItem().invoke(list -> System.out.println(">>> " + list))
                .onItem().disjoint()
                .subscribe().with(System.out::println, Throwable::printStackTrace);
    }
}
