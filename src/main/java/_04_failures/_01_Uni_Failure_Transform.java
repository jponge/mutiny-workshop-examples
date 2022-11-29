///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.0.0
package _04_failures;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

public class _01_Uni_Failure_Transform {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni failure transformation");

        Uni.createFrom().failure(new IOException("Boom"))
                .onFailure(IOException.class).transform(RuntimeException::new)
                .subscribe().with(System.out::println, Throwable::printStackTrace);
    }
}
