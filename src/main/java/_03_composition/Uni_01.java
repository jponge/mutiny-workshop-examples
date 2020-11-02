///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _03_composition;

import io.smallrye.mutiny.Uni;

public class Uni_01 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni transform a value with a function");

        Uni.createFrom().item(123)
                .onItem().transform(n -> n * 100)
                .onItem().transform(Object::toString)
                .subscribe().with(System.out::println);
    }
}
