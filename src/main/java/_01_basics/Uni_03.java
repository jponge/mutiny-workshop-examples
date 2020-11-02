///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _01_basics;

import io.smallrye.mutiny.Uni;

import java.util.Random;

public class Uni_03 {

    public static void main(String[] args) {
        System.out.println("️⚡️ Uni from supplier");

        Random random = new Random();

        Uni<Integer> uniFromSupplier = Uni.createFrom().item(random::nextInt);

        for (var i = 0; i < 5; i++) {
            uniFromSupplier.subscribe().with(System.out::println);
        }
    }
}