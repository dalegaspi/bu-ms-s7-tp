package edu.bu.cs622.bestpurchase.entity;

import java.util.UUID;

public final class IdType {
    private UUID id;

    public IdType() {
         this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
