package edu.bu.cs622.bestpurchase.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerProfileTest {

    @Test
    void createHash() {
        var hash = CustomerProfile.createHash("data");

        assertTrue(hash.isRight());
    }
}
