///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package groups_02;

import io.smallrye.mutiny.Uni;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Uni_01 {

    public static void main(String[] args) {
        System.out.println("⚡️ Uni inspect events");

        var result = Uni.createFrom().item("Hello")
                .onSubscribe().invoke(sub -> System.out.println("onSubscribe " + sub))
                .onCancellation().invoke(() -> System.out.println("onCancellation"))
                .onItem().invoke(item -> System.out.println("onItem " + item))
                .onFailure().invoke(failure -> System.out.println("onFailure " + failure))
                .onItemOrFailure().invoke((item, failure) -> System.out.println("onItemOrFailure " + item + ", " + failure))
                .onTermination().invoke((s, t, c) -> System.out.println("onTermination " + s + ", " + t + ", " + c))
                .await().atMost(Duration.of(5, ChronoUnit.SECONDS));

        System.out.println("📦 uni result = " + result);
        System.out.println("⚠️ This was a blocking operation");
    }
}
