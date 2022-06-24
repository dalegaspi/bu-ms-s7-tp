package edu.bu.cs682.bestpurchase.actors;

import io.vavr.control.Try;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public abstract class SimulatedActor {
    abstract void doSomething();
    private Random random = new Random();
    protected void pause() {
        Try.run(() -> Thread.sleep(random.nextInt(3) * 1000));
    }

    public CompletableFuture<Void> start() {
        return CompletableFuture.runAsync(this::doSomething);
    }
}
