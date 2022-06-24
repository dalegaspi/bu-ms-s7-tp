package edu.bu.cs682.bestpurchase.entities.store;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 * Id type
 *
 * @author dlegaspi@bu.edu
 */
public final class IdType implements Serializable {
    private UUID id;
    private String ez2r;

    public IdType(UUID uuid, String ez2r) {
        this.id = uuid;
        this.ez2r = ez2r;
    }

    public static IdType toIdType(String uuid, String ez2r) {
        return new IdType(UUID.fromString(uuid), ez2r);
    }

    public IdType(String ez2r) {
        this(UUID.randomUUID(), ez2r);
    }

    private static List<String> words = List.of("bread", "robot", "cat", "jam", "goat", "bird", "yam", "hall");
    private static Random random = new Random();

    private static String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }

    public IdType() {
        this(UUID.randomUUID(), getRandomWord());
    }

    @Override
    public String toString() {
        return this.id.toString() + "/" + getEasyToRememberId();
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

    public String getEasyToRememberId() {
        return ez2r;
    }
}
