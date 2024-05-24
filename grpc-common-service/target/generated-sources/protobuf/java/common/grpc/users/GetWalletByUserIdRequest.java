// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package common.grpc.users;

/**
 * Protobuf type {@code common.grpc.users.GetWalletByUserIdRequest}
 */
public final class GetWalletByUserIdRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:common.grpc.users.GetWalletByUserIdRequest)
    GetWalletByUserIdRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetWalletByUserIdRequest.newBuilder() to construct.
  private GetWalletByUserIdRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetWalletByUserIdRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetWalletByUserIdRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return common.grpc.users.Wallet.internal_static_common_grpc_users_GetWalletByUserIdRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return common.grpc.users.Wallet.internal_static_common_grpc_users_GetWalletByUserIdRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            common.grpc.users.GetWalletByUserIdRequest.class, common.grpc.users.GetWalletByUserIdRequest.Builder.class);
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private long userID_;
  /**
   * <code>int64 userID = 1;</code>
   * @return The userID.
   */
  @java.lang.Override
  public long getUserID() {
    return userID_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userID_ != 0L) {
      output.writeInt64(1, userID_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userID_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, userID_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof common.grpc.users.GetWalletByUserIdRequest)) {
      return super.equals(obj);
    }
    common.grpc.users.GetWalletByUserIdRequest other = (common.grpc.users.GetWalletByUserIdRequest) obj;

    if (getUserID()
        != other.getUserID()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserID());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.GetWalletByUserIdRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(common.grpc.users.GetWalletByUserIdRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code common.grpc.users.GetWalletByUserIdRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:common.grpc.users.GetWalletByUserIdRequest)
      common.grpc.users.GetWalletByUserIdRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_GetWalletByUserIdRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_GetWalletByUserIdRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              common.grpc.users.GetWalletByUserIdRequest.class, common.grpc.users.GetWalletByUserIdRequest.Builder.class);
    }

    // Construct using common.grpc.users.GetWalletByUserIdRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      userID_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_GetWalletByUserIdRequest_descriptor;
    }

    @java.lang.Override
    public common.grpc.users.GetWalletByUserIdRequest getDefaultInstanceForType() {
      return common.grpc.users.GetWalletByUserIdRequest.getDefaultInstance();
    }

    @java.lang.Override
    public common.grpc.users.GetWalletByUserIdRequest build() {
      common.grpc.users.GetWalletByUserIdRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public common.grpc.users.GetWalletByUserIdRequest buildPartial() {
      common.grpc.users.GetWalletByUserIdRequest result = new common.grpc.users.GetWalletByUserIdRequest(this);
      result.userID_ = userID_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof common.grpc.users.GetWalletByUserIdRequest) {
        return mergeFrom((common.grpc.users.GetWalletByUserIdRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(common.grpc.users.GetWalletByUserIdRequest other) {
      if (other == common.grpc.users.GetWalletByUserIdRequest.getDefaultInstance()) return this;
      if (other.getUserID() != 0L) {
        setUserID(other.getUserID());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              userID_ = input.readInt64();

              break;
            } // case 8
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private long userID_ ;
    /**
     * <code>int64 userID = 1;</code>
     * @return The userID.
     */
    @java.lang.Override
    public long getUserID() {
      return userID_;
    }
    /**
     * <code>int64 userID = 1;</code>
     * @param value The userID to set.
     * @return This builder for chaining.
     */
    public Builder setUserID(long value) {
      
      userID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 userID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserID() {
      
      userID_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:common.grpc.users.GetWalletByUserIdRequest)
  }

  // @@protoc_insertion_point(class_scope:common.grpc.users.GetWalletByUserIdRequest)
  private static final common.grpc.users.GetWalletByUserIdRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new common.grpc.users.GetWalletByUserIdRequest();
  }

  public static common.grpc.users.GetWalletByUserIdRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetWalletByUserIdRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetWalletByUserIdRequest>() {
    @java.lang.Override
    public GetWalletByUserIdRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GetWalletByUserIdRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetWalletByUserIdRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public common.grpc.users.GetWalletByUserIdRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

