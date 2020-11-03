///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _04_failures;

import java.io.IOException;

import io.smallrye.mutiny.Uni;

public class Uni_02 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni failure recover with item");

        Uni.createFrom().failure(new IOException("Boom"))
                .onFailure(IOException.class).recoverWithItem(Throwable::getMessage)
                .subscribe().with(System.out::println, Throwable::printStackTrace);
    }
}
