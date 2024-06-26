// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package common.grpc.users;

/**
 * Protobuf type {@code common.grpc.users.WalletResponse}
 */
public final class WalletResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:common.grpc.users.WalletResponse)
    WalletResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WalletResponse.newBuilder() to construct.
  private WalletResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WalletResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WalletResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return common.grpc.users.Wallet.internal_static_common_grpc_users_WalletResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return common.grpc.users.Wallet.internal_static_common_grpc_users_WalletResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            common.grpc.users.WalletResponse.class, common.grpc.users.WalletResponse.Builder.class);
  }

  public static final int RESP_FIELD_NUMBER = 1;
  private common.grpc.users.WalletMessage resp_;
  /**
   * <code>.common.grpc.users.WalletMessage resp = 1;</code>
   * @return Whether the resp field is set.
   */
  @java.lang.Override
  public boolean hasResp() {
    return resp_ != null;
  }
  /**
   * <code>.common.grpc.users.WalletMessage resp = 1;</code>
   * @return The resp.
   */
  @java.lang.Override
  public common.grpc.users.WalletMessage getResp() {
    return resp_ == null ? common.grpc.users.WalletMessage.getDefaultInstance() : resp_;
  }
  /**
   * <code>.common.grpc.users.WalletMessage resp = 1;</code>
   */
  @java.lang.Override
  public common.grpc.users.WalletMessageOrBuilder getRespOrBuilder() {
    return getResp();
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
    if (resp_ != null) {
      output.writeMessage(1, getResp());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (resp_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getResp());
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
    if (!(obj instanceof common.grpc.users.WalletResponse)) {
      return super.equals(obj);
    }
    common.grpc.users.WalletResponse other = (common.grpc.users.WalletResponse) obj;

    if (hasResp() != other.hasResp()) return false;
    if (hasResp()) {
      if (!getResp()
          .equals(other.getResp())) return false;
    }
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
    if (hasResp()) {
      hash = (37 * hash) + RESP_FIELD_NUMBER;
      hash = (53 * hash) + getResp().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static common.grpc.users.WalletResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.WalletResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.WalletResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.WalletResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.WalletResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.WalletResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.WalletResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.WalletResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.WalletResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static common.grpc.users.WalletResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.WalletResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.WalletResponse parseFrom(
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
  public static Builder newBuilder(common.grpc.users.WalletResponse prototype) {
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
   * Protobuf type {@code common.grpc.users.WalletResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:common.grpc.users.WalletResponse)
      common.grpc.users.WalletResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_WalletResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_WalletResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              common.grpc.users.WalletResponse.class, common.grpc.users.WalletResponse.Builder.class);
    }

    // Construct using common.grpc.users.WalletResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (respBuilder_ == null) {
        resp_ = null;
      } else {
        resp_ = null;
        respBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_WalletResponse_descriptor;
    }

    @java.lang.Override
    public common.grpc.users.WalletResponse getDefaultInstanceForType() {
      return common.grpc.users.WalletResponse.getDefaultInstance();
    }

    @java.lang.Override
    public common.grpc.users.WalletResponse build() {
      common.grpc.users.WalletResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public common.grpc.users.WalletResponse buildPartial() {
      common.grpc.users.WalletResponse result = new common.grpc.users.WalletResponse(this);
      if (respBuilder_ == null) {
        result.resp_ = resp_;
      } else {
        result.resp_ = respBuilder_.build();
      }
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
      if (other instanceof common.grpc.users.WalletResponse) {
        return mergeFrom((common.grpc.users.WalletResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(common.grpc.users.WalletResponse other) {
      if (other == common.grpc.users.WalletResponse.getDefaultInstance()) return this;
      if (other.hasResp()) {
        mergeResp(other.getResp());
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
            case 10: {
              input.readMessage(
                  getRespFieldBuilder().getBuilder(),
                  extensionRegistry);

              break;
            } // case 10
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

    private common.grpc.users.WalletMessage resp_;
    private com.google.protobuf.SingleFieldBuilderV3<
        common.grpc.users.WalletMessage, common.grpc.users.WalletMessage.Builder, common.grpc.users.WalletMessageOrBuilder> respBuilder_;
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     * @return Whether the resp field is set.
     */
    public boolean hasResp() {
      return respBuilder_ != null || resp_ != null;
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     * @return The resp.
     */
    public common.grpc.users.WalletMessage getResp() {
      if (respBuilder_ == null) {
        return resp_ == null ? common.grpc.users.WalletMessage.getDefaultInstance() : resp_;
      } else {
        return respBuilder_.getMessage();
      }
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    public Builder setResp(common.grpc.users.WalletMessage value) {
      if (respBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        resp_ = value;
        onChanged();
      } else {
        respBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    public Builder setResp(
        common.grpc.users.WalletMessage.Builder builderForValue) {
      if (respBuilder_ == null) {
        resp_ = builderForValue.build();
        onChanged();
      } else {
        respBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    public Builder mergeResp(common.grpc.users.WalletMessage value) {
      if (respBuilder_ == null) {
        if (resp_ != null) {
          resp_ =
            common.grpc.users.WalletMessage.newBuilder(resp_).mergeFrom(value).buildPartial();
        } else {
          resp_ = value;
        }
        onChanged();
      } else {
        respBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    public Builder clearResp() {
      if (respBuilder_ == null) {
        resp_ = null;
        onChanged();
      } else {
        resp_ = null;
        respBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    public common.grpc.users.WalletMessage.Builder getRespBuilder() {
      
      onChanged();
      return getRespFieldBuilder().getBuilder();
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    public common.grpc.users.WalletMessageOrBuilder getRespOrBuilder() {
      if (respBuilder_ != null) {
        return respBuilder_.getMessageOrBuilder();
      } else {
        return resp_ == null ?
            common.grpc.users.WalletMessage.getDefaultInstance() : resp_;
      }
    }
    /**
     * <code>.common.grpc.users.WalletMessage resp = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        common.grpc.users.WalletMessage, common.grpc.users.WalletMessage.Builder, common.grpc.users.WalletMessageOrBuilder> 
        getRespFieldBuilder() {
      if (respBuilder_ == null) {
        respBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            common.grpc.users.WalletMessage, common.grpc.users.WalletMessage.Builder, common.grpc.users.WalletMessageOrBuilder>(
                getResp(),
                getParentForChildren(),
                isClean());
        resp_ = null;
      }
      return respBuilder_;
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


    // @@protoc_insertion_point(builder_scope:common.grpc.users.WalletResponse)
  }

  // @@protoc_insertion_point(class_scope:common.grpc.users.WalletResponse)
  private static final common.grpc.users.WalletResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new common.grpc.users.WalletResponse();
  }

  public static common.grpc.users.WalletResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WalletResponse>
      PARSER = new com.google.protobuf.AbstractParser<WalletResponse>() {
    @java.lang.Override
    public WalletResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<WalletResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WalletResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public common.grpc.users.WalletResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

