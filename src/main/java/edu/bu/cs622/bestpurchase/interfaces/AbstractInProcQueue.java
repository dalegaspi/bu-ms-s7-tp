package edu.bu.cs622.bestpurchase.interfaces;

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

    static protected ZContext context = new ZContext();

    protected AbstractInProcQueue() {

    }

    protected ZMQ.Socket createReceiverSocket() {
        var s = context.createSocket(SocketType.PAIR);
        s.bind(ADDRESS);
        return s;
    }

    protected ZMQ.Socket createSenderSocket() {
        var s = context.createSocket(SocketType.PAIR);
        s.connect(ADDRESS);
        return s;
    }

    public Either<CheckoutException, byte[]> serialize(T entity) {
        return Try.of(() -> {
            var outputStream = new ByteArrayOutputStream();
            var objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(entity);

            var bytes = outputStream.toByteArray();
            objectOutput.close();
            outputStream.close();

            return bytes;
        }).toEither().mapLeft(t -> new CheckoutException("Serialization error", t));
    }

    @SuppressWarnings("unchecked")
    public Either<CheckoutException, T> deserialize(byte[] bytes) {
        return Try.of(() -> {
        var inputStream = new ByteArrayInputStream(bytes);
        var objectInput = new ObjectInputStream(inputStream);

        var entity = objectInput.readObject();
        return (T) entity;
        }).toEither().mapLeft(t -> new CheckoutException("Deserialization error", t));
    }

    protected Either<CheckoutException, Boolean> send(ZMQ.Socket conn, T entity) {
        return serialize(entity)
                .map(bytes -> conn.send(bytes))
                .mapLeft(t -> new CheckoutException("ShoppingCart send error", t));
    }


    protected Either<CheckoutException, T> receive(ZMQ.Socket conn) {
        return Try.of(() -> conn.recv())
                .toEither()
                .mapLeft(t -> new CheckoutException("ShoppingCart receive error", t))
                .flatMap(bytes -> deserialize(bytes));
    }
}
