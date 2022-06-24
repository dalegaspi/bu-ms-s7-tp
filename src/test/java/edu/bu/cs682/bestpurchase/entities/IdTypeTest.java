package edu.bu.cs682.bestpurchase.entities;

import edu.bu.cs682.bestpurchase.entities.store.IdType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdTypeTest {

    @Test
    void getEasyToRememberId() {
        var id = new IdType();
        assertTrue(id.getEasyToRememberId().length() > 0);
    }
}
