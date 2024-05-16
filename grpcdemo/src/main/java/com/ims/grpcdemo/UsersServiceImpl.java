package com.ims.grpcdemo;
import io.grpc.stub.StreamObserver;

public class UsersServiceImpl extends UsersServiceGrpc.UsersServiceImplBase {
    @Override
    public void loginUser(LoginUserRequest req, StreamObserver<LoginUserResponse> responseObserver) {
        // Mock data for demonstration
        boolean success = "user".equals(req.getUsername()) && "password".equals(req.getPassword());
        LoginUserResponse response = LoginUserResponse.newBuilder()
                .setSuccess(success ? "Login successful" : "Login failed")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void signupUser(SignupUserRequest req, StreamObserver<SignupUserResponse> responseObserver) {
        // Mock data for demonstration
        SignupUserResponse response = SignupUserResponse.newBuilder()
                .setSuccess("Signup successful")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}



