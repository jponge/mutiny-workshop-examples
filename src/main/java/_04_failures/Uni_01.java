///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _04_failures;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

public class Uni_01 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni failure transformation");

        Uni.createFrom().failure(new IOException("Boom"))
                .onFailure(IOException.class).transform(RuntimeException::new)
                .subscribe().with(System.out::println, Throwable::printStackTrace);
    }
}
