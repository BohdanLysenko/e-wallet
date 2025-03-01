package common.grpc.users;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.55.1)",
    comments = "Source: users.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "common.grpc.users.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<common.grpc.users.UserTokenRequest,
      common.grpc.users.UserDetailsMessage> getGetUserDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserDetails",
      requestType = common.grpc.users.UserTokenRequest.class,
      responseType = common.grpc.users.UserDetailsMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.UserTokenRequest,
      common.grpc.users.UserDetailsMessage> getGetUserDetailsMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.UserTokenRequest, common.grpc.users.UserDetailsMessage> getGetUserDetailsMethod;
    if ((getGetUserDetailsMethod = UserServiceGrpc.getGetUserDetailsMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserDetailsMethod = UserServiceGrpc.getGetUserDetailsMethod) == null) {
          UserServiceGrpc.getGetUserDetailsMethod = getGetUserDetailsMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.UserTokenRequest, common.grpc.users.UserDetailsMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.UserTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.UserDetailsMessage.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("GetUserDetails"))
              .build();
        }
      }
    }
    return getGetUserDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<common.grpc.users.UserSuspiciousRequest,
      com.google.protobuf.Empty> getUpdateUserSuspiciousActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserSuspiciousActivity",
      requestType = common.grpc.users.UserSuspiciousRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.UserSuspiciousRequest,
      com.google.protobuf.Empty> getUpdateUserSuspiciousActivityMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.UserSuspiciousRequest, com.google.protobuf.Empty> getUpdateUserSuspiciousActivityMethod;
    if ((getUpdateUserSuspiciousActivityMethod = UserServiceGrpc.getUpdateUserSuspiciousActivityMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserSuspiciousActivityMethod = UserServiceGrpc.getUpdateUserSuspiciousActivityMethod) == null) {
          UserServiceGrpc.getUpdateUserSuspiciousActivityMethod = getUpdateUserSuspiciousActivityMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.UserSuspiciousRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserSuspiciousActivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.UserSuspiciousRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUserSuspiciousActivity"))
              .build();
        }
      }
    }
    return getUpdateUserSuspiciousActivityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<common.grpc.users.UserDisabledRequest,
      com.google.protobuf.Empty> getUpdateUserTransactionBlockedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserTransactionBlocked",
      requestType = common.grpc.users.UserDisabledRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.UserDisabledRequest,
      com.google.protobuf.Empty> getUpdateUserTransactionBlockedMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.UserDisabledRequest, com.google.protobuf.Empty> getUpdateUserTransactionBlockedMethod;
    if ((getUpdateUserTransactionBlockedMethod = UserServiceGrpc.getUpdateUserTransactionBlockedMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateUserTransactionBlockedMethod = UserServiceGrpc.getUpdateUserTransactionBlockedMethod) == null) {
          UserServiceGrpc.getUpdateUserTransactionBlockedMethod = getUpdateUserTransactionBlockedMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.UserDisabledRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserTransactionBlocked"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.UserDisabledRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateUserTransactionBlocked"))
              .build();
        }
      }
    }
    return getUpdateUserTransactionBlockedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<common.grpc.users.UserUnblockRequest,
      common.grpc.users.UserUnblockResponse> getUnblockAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnblockAllUsers",
      requestType = common.grpc.users.UserUnblockRequest.class,
      responseType = common.grpc.users.UserUnblockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.UserUnblockRequest,
      common.grpc.users.UserUnblockResponse> getUnblockAllUsersMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.UserUnblockRequest, common.grpc.users.UserUnblockResponse> getUnblockAllUsersMethod;
    if ((getUnblockAllUsersMethod = UserServiceGrpc.getUnblockAllUsersMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUnblockAllUsersMethod = UserServiceGrpc.getUnblockAllUsersMethod) == null) {
          UserServiceGrpc.getUnblockAllUsersMethod = getUnblockAllUsersMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.UserUnblockRequest, common.grpc.users.UserUnblockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnblockAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.UserUnblockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.UserUnblockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UnblockAllUsers"))
              .build();
        }
      }
    }
    return getUnblockAllUsersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getUserDetails(common.grpc.users.UserTokenRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.UserDetailsMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserDetailsMethod(), responseObserver);
    }

    /**
     */
    default void updateUserSuspiciousActivity(common.grpc.users.UserSuspiciousRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserSuspiciousActivityMethod(), responseObserver);
    }

    /**
     */
    default void updateUserTransactionBlocked(common.grpc.users.UserDisabledRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserTransactionBlockedMethod(), responseObserver);
    }

    /**
     */
    default void unblockAllUsers(common.grpc.users.UserUnblockRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.UserUnblockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnblockAllUsersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserService.
   */
  public static abstract class UserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserService.
   */
  public static final class UserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserDetails(common.grpc.users.UserTokenRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.UserDetailsMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUserSuspiciousActivity(common.grpc.users.UserSuspiciousRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserSuspiciousActivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUserTransactionBlocked(common.grpc.users.UserDisabledRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserTransactionBlockedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unblockAllUsers(common.grpc.users.UserUnblockRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.UserUnblockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnblockAllUsersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserService.
   */
  public static final class UserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public common.grpc.users.UserDetailsMessage getUserDetails(common.grpc.users.UserTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateUserSuspiciousActivity(common.grpc.users.UserSuspiciousRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserSuspiciousActivityMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateUserTransactionBlocked(common.grpc.users.UserDisabledRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserTransactionBlockedMethod(), getCallOptions(), request);
    }

    /**
     */
    public common.grpc.users.UserUnblockResponse unblockAllUsers(common.grpc.users.UserUnblockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnblockAllUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserService.
   */
  public static final class UserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<common.grpc.users.UserDetailsMessage> getUserDetails(
        common.grpc.users.UserTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserDetailsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateUserSuspiciousActivity(
        common.grpc.users.UserSuspiciousRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserSuspiciousActivityMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateUserTransactionBlocked(
        common.grpc.users.UserDisabledRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserTransactionBlockedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<common.grpc.users.UserUnblockResponse> unblockAllUsers(
        common.grpc.users.UserUnblockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnblockAllUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_DETAILS = 0;
  private static final int METHODID_UPDATE_USER_SUSPICIOUS_ACTIVITY = 1;
  private static final int METHODID_UPDATE_USER_TRANSACTION_BLOCKED = 2;
  private static final int METHODID_UNBLOCK_ALL_USERS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_DETAILS:
          serviceImpl.getUserDetails((common.grpc.users.UserTokenRequest) request,
              (io.grpc.stub.StreamObserver<common.grpc.users.UserDetailsMessage>) responseObserver);
          break;
        case METHODID_UPDATE_USER_SUSPICIOUS_ACTIVITY:
          serviceImpl.updateUserSuspiciousActivity((common.grpc.users.UserSuspiciousRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_USER_TRANSACTION_BLOCKED:
          serviceImpl.updateUserTransactionBlocked((common.grpc.users.UserDisabledRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNBLOCK_ALL_USERS:
          serviceImpl.unblockAllUsers((common.grpc.users.UserUnblockRequest) request,
              (io.grpc.stub.StreamObserver<common.grpc.users.UserUnblockResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetUserDetailsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              common.grpc.users.UserTokenRequest,
              common.grpc.users.UserDetailsMessage>(
                service, METHODID_GET_USER_DETAILS)))
        .addMethod(
          getUpdateUserSuspiciousActivityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              common.grpc.users.UserSuspiciousRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_USER_SUSPICIOUS_ACTIVITY)))
        .addMethod(
          getUpdateUserTransactionBlockedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              common.grpc.users.UserDisabledRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_USER_TRANSACTION_BLOCKED)))
        .addMethod(
          getUnblockAllUsersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              common.grpc.users.UserUnblockRequest,
              common.grpc.users.UserUnblockResponse>(
                service, METHODID_UNBLOCK_ALL_USERS)))
        .build();
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return common.grpc.users.Users.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getGetUserDetailsMethod())
              .addMethod(getUpdateUserSuspiciousActivityMethod())
              .addMethod(getUpdateUserTransactionBlockedMethod())
              .addMethod(getUnblockAllUsersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
