///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:1.3.1
package _07_misc;

import java.util.List;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;

public class _03_Context {

    public static void main(String[] args) {
        System.out.println("⚡️ Using subscription-bound contexts");

        Context context = Context.of("foo", 123, "bar", "abc-123-def");

        List<String> list = Multi.createFrom().range(1, 10)
                .withContext((multi, ctx) -> multi.onItem().invoke(n -> ctx.put("n", n)))
                .select().where(n -> n % 2 == 0)
                .withContext((multi, ctx) -> multi.onItem().transform(n -> n + "::" + ctx.get("n")))
                .collect().asList()
                .awaitUsing(context).indefinitely();

        System.out.println(list);
    }
}
