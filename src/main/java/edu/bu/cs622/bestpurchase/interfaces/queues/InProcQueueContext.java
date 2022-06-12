package edu.bu.cs622.bestpurchase.interfaces.queues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZContext;

import java.util.UUID;

public class InProcQueueContext {
    private static Logger logger = LoggerFactory.getLogger(InProcQueueContext.class);

    private ZContext context;
    private String address;

    public InProcQueueContext() {
        context = new ZContext();
        address = "inproc://" + UUID.randomUUID();
        logger.debug("New ZeroMQ In-Proc Context with address {}", address);
    }

    public ZContext getContext() {
        return context;
    }

    public String getAddress() {
        return address;
    }
}
