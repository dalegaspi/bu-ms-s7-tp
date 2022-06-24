package edu.bu.cs682.bestpurchase.entities;

import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerProfileTest {

    @Test
    void createHash() {
        var hash = CustomerProfile.createHash("data");

        assertTrue(hash.isRight());
    }
}
