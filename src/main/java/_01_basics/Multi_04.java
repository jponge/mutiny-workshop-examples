///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.10.1
package _01_basics;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import org.reactivestreams.Subscription;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Multi_04 {

    public static void main(String[] args) {

        Multi.createFrom()
                .ticks().every(Duration.of(1, ChronoUnit.SECONDS))
                .subscribe().withSubscriber(new MultiSubscriber<Long>() {

                    private Subscription subscription;
                    private int counter = 0;

                    @Override
                    public void onItem(Long tick) {
                        System.out.println("Tick: " + tick);
                        if (counter++ == 10) {
                            subscription.cancel();
                        } else {
                            subscription.request(1);
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onCompletion() {
                        System.out.println("Done!");
                    }

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(1);
                    }
                });

    }
}
