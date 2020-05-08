package com.zemrow.test.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;

public class RunTestGrpcClient {
    public static void main(String[] args) throws InterruptedException {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        final ChatGrpc.ChatBlockingStub blockingStub = ChatGrpc.newBlockingStub(channel);

        ChatGrpc.request = Helloworld.HelloRequest.newBuilder().setName("name").build();
        ChatGrpc.HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        }
        catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("response: " + response.getMessage());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
