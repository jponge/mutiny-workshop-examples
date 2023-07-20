///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.3.1
package _01_basics;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

public class _08_Uni_From_Failure {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni from failure");

        Uni.createFrom().failure(new IOException("Boom"))
                .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));

        Uni.createFrom().failure(() -> new IOException("Badaboom"))
                .subscribe().with(System.out::println, failure -> System.out.println(failure.getMessage()));
    }
}
