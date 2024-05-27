package com.ims.grpcdemo;

import io.grpc.stub.StreamObserver;

public class UsersServiceImpl extends UsersServiceGrpc.UsersServiceImplBase {
    @Override
    public void capabilityOfUser(CapabilityOfUserRequest req,
            StreamObserver<CapabilityOfUserResponse> responseObserver) {
        CapabilityOfUserResponse response;
        switch (req.getUserType()) {
            case ADMIN:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities("ADMIN can do everything they want.")
                        .build();
                break;
            case CUSTOMER:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities("CUSTOMER can do everything they want.")
                        .build();
                break;
            case IMPORT_MANAGER:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities("IMPORT_MANAGER can do everything they want.")
                        .build();
                break;
            case SUPPLIER:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities("SUPPLIER can do everything they want.")
                        .build();
                break;
            default:
                response = CapabilityOfUserResponse.newBuilder().setCapabilities("Not valid user type.").build();
                break;
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
