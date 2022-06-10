package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractInProcQueue<T> {

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

    protected Either<CheckoutException, Void> send(ZMQ.Socket conn, T entity) {
        return Try.run(() -> {
            var outputStream = new ByteArrayOutputStream();
            var objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(entity);

            var bytes = outputStream.toByteArray();
            objectOutput.close();
            outputStream.close();

            conn.send(bytes);
        }).toEither().mapLeft(t -> new CheckoutException("ShoppingCart send error", t));
    }

    @SuppressWarnings("unchecked")
    protected Either<CheckoutException, T> receive(ZMQ.Socket conn) {
        return Try.of(() -> {
            var bytes = conn.recv();
            var inputStream = new ByteArrayInputStream(bytes);
            var objectInput = new ObjectInputStream(inputStream);

            var entity = objectInput.readObject();
            return (T) entity;
        }).toEither().mapLeft(t -> new CheckoutException("ShoppingCart receive error", t));
    }
}
