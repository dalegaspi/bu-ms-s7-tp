package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.interfaces.hardware.BasicCameraSimulator;
import edu.bu.cs622.bestpurchase.interfaces.components.BasicQRItemLookup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicQRItemLookupTest {

    @Test
    void convertQRCodeToItemId() {
        var converter = new BasicQRItemLookup();
        var camera = new BasicCameraSimulator();

        var qr = camera.scan();
        assertTrue(qr.isRight());

        var id = qr.flatMap(converter::convertQRCodeToItemId);
        assertTrue(id.isRight() && id.get().getEasyToRememberId().equalsIgnoreCase("hotdog"));
    }
}
