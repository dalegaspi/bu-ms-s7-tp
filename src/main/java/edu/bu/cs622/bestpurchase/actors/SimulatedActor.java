package edu.bu.cs622.bestpurchase.actors;

import java.util.concurrent.CompletableFuture;

public abstract class SimulatedActor {
    abstract void doSomething();

    public CompletableFuture<Void> start() {
        return CompletableFuture.runAsync(this::doSomething);
    }
}
