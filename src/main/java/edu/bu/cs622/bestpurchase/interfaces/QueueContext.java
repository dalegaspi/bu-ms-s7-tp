package edu.bu.cs622.bestpurchase.interfaces;

import org.zeromq.ZContext;

import java.util.UUID;

public class QueueContext {

    private ZContext context;
    private String address;

    public QueueContext() {
        context = new ZContext();
        address = "inproc://" + UUID.randomUUID();
    }

    public ZContext getContext() {
        return context;
    }

    public String getAddress() {
        return address;
    }
}
