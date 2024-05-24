package common.grpc.users;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: wallet.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WalletServiceGrpc {

  private WalletServiceGrpc() {}

  public static final String SERVICE_NAME = "common.grpc.users.WalletService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<common.grpc.users.CreateWalletRequest,
      common.grpc.users.WalletResponse> getCreateWalletMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createWallet",
      requestType = common.grpc.users.CreateWalletRequest.class,
      responseType = common.grpc.users.WalletResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.CreateWalletRequest,
      common.grpc.users.WalletResponse> getCreateWalletMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.CreateWalletRequest, common.grpc.users.WalletResponse> getCreateWalletMethod;
    if ((getCreateWalletMethod = WalletServiceGrpc.getCreateWalletMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getCreateWalletMethod = WalletServiceGrpc.getCreateWalletMethod) == null) {
          WalletServiceGrpc.getCreateWalletMethod = getCreateWalletMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.CreateWalletRequest, common.grpc.users.WalletResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createWallet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.CreateWalletRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.WalletResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("createWallet"))
              .build();
        }
      }
    }
    return getCreateWalletMethod;
  }

  private static volatile io.grpc.MethodDescriptor<common.grpc.users.GetWalletByUserIdRequest,
      common.grpc.users.WalletResponse> getGetWalletByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getWalletByUserId",
      requestType = common.grpc.users.GetWalletByUserIdRequest.class,
      responseType = common.grpc.users.WalletResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.GetWalletByUserIdRequest,
      common.grpc.users.WalletResponse> getGetWalletByUserIdMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.GetWalletByUserIdRequest, common.grpc.users.WalletResponse> getGetWalletByUserIdMethod;
    if ((getGetWalletByUserIdMethod = WalletServiceGrpc.getGetWalletByUserIdMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getGetWalletByUserIdMethod = WalletServiceGrpc.getGetWalletByUserIdMethod) == null) {
          WalletServiceGrpc.getGetWalletByUserIdMethod = getGetWalletByUserIdMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.GetWalletByUserIdRequest, common.grpc.users.WalletResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getWalletByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.GetWalletByUserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.WalletResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("getWalletByUserId"))
              .build();
        }
      }
    }
    return getGetWalletByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<common.grpc.users.HealthCheckRequest,
      common.grpc.users.HealthCheckResponse> getCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Check",
      requestType = common.grpc.users.HealthCheckRequest.class,
      responseType = common.grpc.users.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<common.grpc.users.HealthCheckRequest,
      common.grpc.users.HealthCheckResponse> getCheckMethod() {
    io.grpc.MethodDescriptor<common.grpc.users.HealthCheckRequest, common.grpc.users.HealthCheckResponse> getCheckMethod;
    if ((getCheckMethod = WalletServiceGrpc.getCheckMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getCheckMethod = WalletServiceGrpc.getCheckMethod) == null) {
          WalletServiceGrpc.getCheckMethod = getCheckMethod =
              io.grpc.MethodDescriptor.<common.grpc.users.HealthCheckRequest, common.grpc.users.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Check"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.HealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("Check"))
              .build();
        }
      }
    }
    return getCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      common.grpc.users.AllWalletsResponse> getGetAllWalletsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllWallets",
      requestType = com.google.protobuf.Empty.class,
      responseType = common.grpc.users.AllWalletsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      common.grpc.users.AllWalletsResponse> getGetAllWalletsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, common.grpc.users.AllWalletsResponse> getGetAllWalletsMethod;
    if ((getGetAllWalletsMethod = WalletServiceGrpc.getGetAllWalletsMethod) == null) {
      synchronized (WalletServiceGrpc.class) {
        if ((getGetAllWalletsMethod = WalletServiceGrpc.getGetAllWalletsMethod) == null) {
          WalletServiceGrpc.getGetAllWalletsMethod = getGetAllWalletsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, common.grpc.users.AllWalletsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllWallets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  common.grpc.users.AllWalletsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WalletServiceMethodDescriptorSupplier("getAllWallets"))
              .build();
        }
      }
    }
    return getGetAllWalletsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WalletServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WalletServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WalletServiceStub>() {
        @java.lang.Override
        public WalletServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WalletServiceStub(channel, callOptions);
        }
      };
    return WalletServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WalletServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WalletServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WalletServiceBlockingStub>() {
        @java.lang.Override
        public WalletServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WalletServiceBlockingStub(channel, callOptions);
        }
      };
    return WalletServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WalletServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WalletServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WalletServiceFutureStub>() {
        @java.lang.Override
        public WalletServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WalletServiceFutureStub(channel, callOptions);
        }
      };
    return WalletServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class WalletServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createWallet(common.grpc.users.CreateWalletRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.WalletResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWalletMethod(), responseObserver);
    }

    /**
     */
    public void getWalletByUserId(common.grpc.users.GetWalletByUserIdRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.WalletResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWalletByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void check(common.grpc.users.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckMethod(), responseObserver);
    }

    /**
     */
    public void getAllWallets(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<common.grpc.users.AllWalletsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllWalletsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateWalletMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                common.grpc.users.CreateWalletRequest,
                common.grpc.users.WalletResponse>(
                  this, METHODID_CREATE_WALLET)))
          .addMethod(
            getGetWalletByUserIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                common.grpc.users.GetWalletByUserIdRequest,
                common.grpc.users.WalletResponse>(
                  this, METHODID_GET_WALLET_BY_USER_ID)))
          .addMethod(
            getCheckMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                common.grpc.users.HealthCheckRequest,
                common.grpc.users.HealthCheckResponse>(
                  this, METHODID_CHECK)))
          .addMethod(
            getGetAllWalletsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                common.grpc.users.AllWalletsResponse>(
                  this, METHODID_GET_ALL_WALLETS)))
          .build();
    }
  }

  /**
   */
  public static final class WalletServiceStub extends io.grpc.stub.AbstractAsyncStub<WalletServiceStub> {
    private WalletServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WalletServiceStub(channel, callOptions);
    }

    /**
     */
    public void createWallet(common.grpc.users.CreateWalletRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.WalletResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWalletMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWalletByUserId(common.grpc.users.GetWalletByUserIdRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.WalletResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWalletByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void check(common.grpc.users.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<common.grpc.users.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllWallets(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<common.grpc.users.AllWalletsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllWalletsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WalletServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WalletServiceBlockingStub> {
    private WalletServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WalletServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public common.grpc.users.WalletResponse createWallet(common.grpc.users.CreateWalletRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWalletMethod(), getCallOptions(), request);
    }

    /**
     */
    public common.grpc.users.WalletResponse getWalletByUserId(common.grpc.users.GetWalletByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWalletByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public common.grpc.users.HealthCheckResponse check(common.grpc.users.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckMethod(), getCallOptions(), request);
    }

    /**
     */
    public common.grpc.users.AllWalletsResponse getAllWallets(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllWalletsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WalletServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WalletServiceFutureStub> {
    private WalletServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WalletServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<common.grpc.users.WalletResponse> createWallet(
        common.grpc.users.CreateWalletRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWalletMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<common.grpc.users.WalletResponse> getWalletByUserId(
        common.grpc.users.GetWalletByUserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWalletByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<common.grpc.users.HealthCheckResponse> check(
        common.grpc.users.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<common.grpc.users.AllWalletsResponse> getAllWallets(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllWalletsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WALLET = 0;
  private static final int METHODID_GET_WALLET_BY_USER_ID = 1;
  private static final int METHODID_CHECK = 2;
  private static final int METHODID_GET_ALL_WALLETS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WalletServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WalletServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WALLET:
          serviceImpl.createWallet((common.grpc.users.CreateWalletRequest) request,
              (io.grpc.stub.StreamObserver<common.grpc.users.WalletResponse>) responseObserver);
          break;
        case METHODID_GET_WALLET_BY_USER_ID:
          serviceImpl.getWalletByUserId((common.grpc.users.GetWalletByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<common.grpc.users.WalletResponse>) responseObserver);
          break;
        case METHODID_CHECK:
          serviceImpl.check((common.grpc.users.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<common.grpc.users.HealthCheckResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_WALLETS:
          serviceImpl.getAllWallets((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<common.grpc.users.AllWalletsResponse>) responseObserver);
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

  private static abstract class WalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WalletServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return common.grpc.users.Wallet.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WalletService");
    }
  }

  private static final class WalletServiceFileDescriptorSupplier
      extends WalletServiceBaseDescriptorSupplier {
    WalletServiceFileDescriptorSupplier() {}
  }

  private static final class WalletServiceMethodDescriptorSupplier
      extends WalletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WalletServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WalletServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WalletServiceFileDescriptorSupplier())
              .addMethod(getCreateWalletMethod())
              .addMethod(getGetWalletByUserIdMethod())
              .addMethod(getCheckMethod())
              .addMethod(getGetAllWalletsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
