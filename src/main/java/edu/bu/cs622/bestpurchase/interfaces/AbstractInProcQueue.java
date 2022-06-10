package edu.bu.cs622.bestpurchase.interfaces;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public abstract class AbstractInProcQueue {

    private final String ADDRESS = "inproc://best-purchase-checkout-queue";

    protected ZContext context;

    protected AbstractInProcQueue() {
        context = new ZContext();
    }

    protected ZMQ.Socket createReceiverSocket() {
        var s = context.createSocket(SocketType.REP);
        s.bind(ADDRESS);
        return s;
    }

    protected ZMQ.Socket createSenderSocket() {
        var s = context.createSocket(SocketType.REP);
        s.connect(ADDRESS);
        return s;
    }
}
