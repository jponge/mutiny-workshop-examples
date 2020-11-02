///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1R
package groups_02;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class Multi_02 {

    public static void main(String[] args) {
        System.out.println("⚡️ Multi invoke / call shortcuts");

        Multi.createFrom().range(1, 10)
                .invoke(n -> System.out.println("n = " + n))
                .call(n -> Uni.createFrom()
                        .voidItem().invoke(() -> System.out.println("call(" + n + ")")))
                .subscribe().with(System.out::println);
    }
}
