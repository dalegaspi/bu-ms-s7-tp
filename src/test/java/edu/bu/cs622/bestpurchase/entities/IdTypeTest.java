package edu.bu.cs622.bestpurchase.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdTypeTest {

    @Test
    void getEasyToRememberId() {
        var id = new IdType();
        assertTrue(id.getEasyToRememberId().length() > 0);
    }
}