package com.ims.grpcdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

@SpringBootApplication
public class UsersServer {
    private Server server;

    private void start() throws IOException {
        int port = 8181;
        server = ServerBuilder.forPort(port)
                .addService(new UsersServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("* shutting down gRPC server since JVM is shutting down");
            UsersServer.this.stop();
            System.err.println("* server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final UsersServer server = new UsersServer();
        server.start();
        server.blockUntilShutdown();
    }

}