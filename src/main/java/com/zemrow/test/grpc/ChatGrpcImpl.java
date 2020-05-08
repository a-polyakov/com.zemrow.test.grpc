package com.zemrow.test.grpc;

import io.grpc.stub.StreamObserver;
import java.util.UUID;

public class ChatGrpcImpl extends ChatGrpc.ChatImplBase {
    @Override
    public void sendMessage(SendMessageRequest request, StreamObserver<SendMessageResponse> responseObserver) {
        SendMessageResponse reply = SendMessageResponse.newBuilder().setMessageId(UUID.randomUUID().getLeastSignificantBits()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
