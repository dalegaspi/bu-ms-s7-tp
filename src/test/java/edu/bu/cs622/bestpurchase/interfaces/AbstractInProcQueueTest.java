package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.config.SimpleAppConfig;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.interfaces.queues.AbstractInProcQueue;
import edu.bu.cs622.bestpurchase.interfaces.queues.InProcQueueContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractInProcQueueTest {

    @Test
    void testSimpleBinarySerialization() {
        var ctx = new InProcQueueContext();
        var q = new AbstractInProcQueue<String>(ctx, new SimpleAppConfig()) {
        };

        var bytes = q.serialize("hello");
        assertTrue(bytes.isRight());

        var s = q.deserialize(bytes.get());
        assertTrue(s.isRight() && s.get().equals("hello"));
    }

    @Test
    void testComplexBinarySerialization() {
        var ctx = new InProcQueueContext();
        var q = new AbstractInProcQueue<ShoppingCart>(ctx, new SimpleAppConfig()) {
        };

        var bytes = q.serialize(new ShoppingCart());
        assertTrue(bytes.isRight());

        var c = q.deserialize(bytes.get());
        assertTrue(c.isRight() && c.get() != null);
    }
}
