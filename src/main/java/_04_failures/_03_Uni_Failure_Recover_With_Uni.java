///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:2.0.0
package _04_failures;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

public class _03_Uni_Failure_Recover_With_Uni {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni failure recover with Uni");

        Uni.createFrom().failure(new IOException("Boom"))
                .onFailure(IOException.class).recoverWithUni(t -> Uni.createFrom().item("N/A -> " + t.getMessage()))
                .subscribe().with(System.out::println, Throwable::printStackTrace);
    }
}
