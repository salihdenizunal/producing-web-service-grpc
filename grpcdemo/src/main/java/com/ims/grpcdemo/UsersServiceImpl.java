package com.ims.grpcdemo;

import io.grpc.stub.StreamObserver;

public class UsersServiceImpl extends UsersServiceGrpc.UsersServiceImplBase {
    @Override
    public void capabilityOfUser(CapabilityOfUserRequest req,
            StreamObserver<CapabilityOfUserResponse> responseObserver) {
        CapabilityOfUserResponse response;
        switch (req.getUserType()) {
            case ADMIN:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities(
                        "ADMIN can create, update, delete, read users. Also, they can create, update, delete, read products. They can do everything they want.")
                        .build();
                break;
            case CUSTOMER:
                response = CapabilityOfUserResponse.newBuilder()
                        .setCapabilities("CUSTOMER can read products and create, update, delete, read their orders.")
                        .build();
                break;
            case IMPORT_MANAGER:
                response = CapabilityOfUserResponse.newBuilder()
                        .setCapabilities(
                                "IMPORT MANAGER can create, update, delete, read products. Also, they can create, update, delete, read orders.")
                        .build();
                break;
            case SUPPLIER:
                response = CapabilityOfUserResponse.newBuilder()
                        .setCapabilities(
                                "SUPPLIER can create, update, delete, read products. Also, they can regulate the stock.")
                        .build();
                break;
            default:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities("Not valid user role.").build();
                break;
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
