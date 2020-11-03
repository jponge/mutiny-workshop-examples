///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _01_basics;

import io.smallrye.mutiny.Uni;

import java.util.List;

public class Uni_12 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni disjoint");

        Uni.createFrom().item(List.of(1, 2, 3, 4, 5))
                .onItem().disjoint()
                .subscribe().with(System.out::println);
    }
}
