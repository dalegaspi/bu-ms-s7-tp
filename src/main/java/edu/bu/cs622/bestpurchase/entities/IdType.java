package edu.bu.cs622.bestpurchase.entities;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IdType idType = (IdType) o;
        return id.equals(idType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
