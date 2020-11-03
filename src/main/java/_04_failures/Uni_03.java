///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _04_failures;

import java.io.IOException;

import io.smallrye.mutiny.Uni;

public class Uni_03 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni failure recover with Uni");

        Uni.createFrom().failure(new IOException("Boom"))
                .onFailure(IOException.class).recoverWithUni(t -> Uni.createFrom().item("N/A -> " + t.getMessage()))
                .subscribe().with(System.out::println, Throwable::printStackTrace);
    }
}