///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _02_groups;

import io.smallrye.mutiny.Multi;

import java.util.stream.Collectors;

public class _04_Multi_Event_Groups {

    public static void main(String[] args) {
        System.out.println("⚡️ Multi inspect events");

        var items = Multi.createFrom().range(1, 6)
                .onSubscribe().invoke(sub -> System.out.println("onSubscribe " + sub))
                .onRequest().invoke(count -> System.out.println("onRequest " + count))
                .onCancellation().invoke(() -> System.out.println("onCancellation"))
                .onItem().invoke(item -> System.out.println("onItem " + item))
                .onFailure().invoke(failure -> System.out.println("onFailure " + failure))
                .onCompletion().invoke(() -> System.out.println("onCompletion"))
                .onTermination().invoke((t, c) -> System.out.println("onTermination " + t + ", c"))
                .subscribe()
                .asStream().collect(Collectors.toList());

        System.out.println("📦 multi items = " + items);
        System.out.println("⚠️ This was a blocking operation");
    }
}