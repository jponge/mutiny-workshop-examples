///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.12.5
package _03_composition_transformation;

import io.smallrye.mutiny.Uni;

import java.io.IOException;

public class _04_Uni_Stage {

    public static void main(String[] args) {
        System.out.println("⚡️ Stages (with Uni)");

        Uni.createFrom().item(123)
                .stage(uni -> processEvents(uni))
                .stage(uni -> handleItem(uni))
                .stage(uni -> handleFailure(uni))
                .subscribe().with(System.out::println, Throwable::printStackTrace);

    }

    private static Uni<Integer> handleFailure(Uni<Integer> uni) {
        return uni
                .onFailure().invoke(failure -> System.out.println("There is a failure: " + failure.getMessage()))
                .onFailure(IOException.class).recoverWithItem(-1);
    }

    private static Uni<Integer> handleItem(Uni<Integer> uni) {
        return uni
                .onItem().ifNotNull().invoke(() -> System.out.println("The item is not null"))
                .onItem().transform(n -> n * 10);
    }

    private static Uni<Integer> processEvents(Uni<Integer> uni) {
        return uni
                .onSubscribe().invoke(() -> System.out.println("onSubscribe"))
                .onItem().invoke(n -> System.out.println("item = " + n));
    }
}
