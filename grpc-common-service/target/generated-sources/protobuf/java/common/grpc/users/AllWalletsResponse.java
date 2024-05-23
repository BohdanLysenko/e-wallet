// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package common.grpc.users;

/**
 * Protobuf type {@code common.grpc.users.AllWalletsResponse}
 */
public final class AllWalletsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:common.grpc.users.AllWalletsResponse)
    AllWalletsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AllWalletsResponse.newBuilder() to construct.
  private AllWalletsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AllWalletsResponse() {
    wallets_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AllWalletsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return common.grpc.users.Wallet.internal_static_common_grpc_users_AllWalletsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return common.grpc.users.Wallet.internal_static_common_grpc_users_AllWalletsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            common.grpc.users.AllWalletsResponse.class, common.grpc.users.AllWalletsResponse.Builder.class);
  }

  public static final int WALLETS_FIELD_NUMBER = 1;
  private java.util.List<common.grpc.users.WalletMessage> wallets_;
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  @java.lang.Override
  public java.util.List<common.grpc.users.WalletMessage> getWalletsList() {
    return wallets_;
  }
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends common.grpc.users.WalletMessageOrBuilder> 
      getWalletsOrBuilderList() {
    return wallets_;
  }
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  @java.lang.Override
  public int getWalletsCount() {
    return wallets_.size();
  }
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  @java.lang.Override
  public common.grpc.users.WalletMessage getWallets(int index) {
    return wallets_.get(index);
  }
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  @java.lang.Override
  public common.grpc.users.WalletMessageOrBuilder getWalletsOrBuilder(
      int index) {
    return wallets_.get(index);
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
    for (int i = 0; i < wallets_.size(); i++) {
      output.writeMessage(1, wallets_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < wallets_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, wallets_.get(i));
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
    if (!(obj instanceof common.grpc.users.AllWalletsResponse)) {
      return super.equals(obj);
    }
    common.grpc.users.AllWalletsResponse other = (common.grpc.users.AllWalletsResponse) obj;

    if (!getWalletsList()
        .equals(other.getWalletsList())) return false;
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
    if (getWalletsCount() > 0) {
      hash = (37 * hash) + WALLETS_FIELD_NUMBER;
      hash = (53 * hash) + getWalletsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static common.grpc.users.AllWalletsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.AllWalletsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static common.grpc.users.AllWalletsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.AllWalletsResponse parseFrom(
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
  public static Builder newBuilder(common.grpc.users.AllWalletsResponse prototype) {
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
   * Protobuf type {@code common.grpc.users.AllWalletsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:common.grpc.users.AllWalletsResponse)
      common.grpc.users.AllWalletsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_AllWalletsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_AllWalletsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              common.grpc.users.AllWalletsResponse.class, common.grpc.users.AllWalletsResponse.Builder.class);
    }

    // Construct using common.grpc.users.AllWalletsResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (walletsBuilder_ == null) {
        wallets_ = java.util.Collections.emptyList();
      } else {
        wallets_ = null;
        walletsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return common.grpc.users.Wallet.internal_static_common_grpc_users_AllWalletsResponse_descriptor;
    }

    @java.lang.Override
    public common.grpc.users.AllWalletsResponse getDefaultInstanceForType() {
      return common.grpc.users.AllWalletsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public common.grpc.users.AllWalletsResponse build() {
      common.grpc.users.AllWalletsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public common.grpc.users.AllWalletsResponse buildPartial() {
      common.grpc.users.AllWalletsResponse result = new common.grpc.users.AllWalletsResponse(this);
      int from_bitField0_ = bitField0_;
      if (walletsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          wallets_ = java.util.Collections.unmodifiableList(wallets_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.wallets_ = wallets_;
      } else {
        result.wallets_ = walletsBuilder_.build();
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
      if (other instanceof common.grpc.users.AllWalletsResponse) {
        return mergeFrom((common.grpc.users.AllWalletsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(common.grpc.users.AllWalletsResponse other) {
      if (other == common.grpc.users.AllWalletsResponse.getDefaultInstance()) return this;
      if (walletsBuilder_ == null) {
        if (!other.wallets_.isEmpty()) {
          if (wallets_.isEmpty()) {
            wallets_ = other.wallets_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureWalletsIsMutable();
            wallets_.addAll(other.wallets_);
          }
          onChanged();
        }
      } else {
        if (!other.wallets_.isEmpty()) {
          if (walletsBuilder_.isEmpty()) {
            walletsBuilder_.dispose();
            walletsBuilder_ = null;
            wallets_ = other.wallets_;
            bitField0_ = (bitField0_ & ~0x00000001);
            walletsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getWalletsFieldBuilder() : null;
          } else {
            walletsBuilder_.addAllMessages(other.wallets_);
          }
        }
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
              common.grpc.users.WalletMessage m =
                  input.readMessage(
                      common.grpc.users.WalletMessage.parser(),
                      extensionRegistry);
              if (walletsBuilder_ == null) {
                ensureWalletsIsMutable();
                wallets_.add(m);
              } else {
                walletsBuilder_.addMessage(m);
              }
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
    private int bitField0_;

    private java.util.List<common.grpc.users.WalletMessage> wallets_ =
      java.util.Collections.emptyList();
    private void ensureWalletsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        wallets_ = new java.util.ArrayList<common.grpc.users.WalletMessage>(wallets_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        common.grpc.users.WalletMessage, common.grpc.users.WalletMessage.Builder, common.grpc.users.WalletMessageOrBuilder> walletsBuilder_;

    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public java.util.List<common.grpc.users.WalletMessage> getWalletsList() {
      if (walletsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(wallets_);
      } else {
        return walletsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public int getWalletsCount() {
      if (walletsBuilder_ == null) {
        return wallets_.size();
      } else {
        return walletsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public common.grpc.users.WalletMessage getWallets(int index) {
      if (walletsBuilder_ == null) {
        return wallets_.get(index);
      } else {
        return walletsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder setWallets(
        int index, common.grpc.users.WalletMessage value) {
      if (walletsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureWalletsIsMutable();
        wallets_.set(index, value);
        onChanged();
      } else {
        walletsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder setWallets(
        int index, common.grpc.users.WalletMessage.Builder builderForValue) {
      if (walletsBuilder_ == null) {
        ensureWalletsIsMutable();
        wallets_.set(index, builderForValue.build());
        onChanged();
      } else {
        walletsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder addWallets(common.grpc.users.WalletMessage value) {
      if (walletsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureWalletsIsMutable();
        wallets_.add(value);
        onChanged();
      } else {
        walletsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder addWallets(
        int index, common.grpc.users.WalletMessage value) {
      if (walletsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureWalletsIsMutable();
        wallets_.add(index, value);
        onChanged();
      } else {
        walletsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder addWallets(
        common.grpc.users.WalletMessage.Builder builderForValue) {
      if (walletsBuilder_ == null) {
        ensureWalletsIsMutable();
        wallets_.add(builderForValue.build());
        onChanged();
      } else {
        walletsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder addWallets(
        int index, common.grpc.users.WalletMessage.Builder builderForValue) {
      if (walletsBuilder_ == null) {
        ensureWalletsIsMutable();
        wallets_.add(index, builderForValue.build());
        onChanged();
      } else {
        walletsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder addAllWallets(
        java.lang.Iterable<? extends common.grpc.users.WalletMessage> values) {
      if (walletsBuilder_ == null) {
        ensureWalletsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, wallets_);
        onChanged();
      } else {
        walletsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder clearWallets() {
      if (walletsBuilder_ == null) {
        wallets_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        walletsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public Builder removeWallets(int index) {
      if (walletsBuilder_ == null) {
        ensureWalletsIsMutable();
        wallets_.remove(index);
        onChanged();
      } else {
        walletsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public common.grpc.users.WalletMessage.Builder getWalletsBuilder(
        int index) {
      return getWalletsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public common.grpc.users.WalletMessageOrBuilder getWalletsOrBuilder(
        int index) {
      if (walletsBuilder_ == null) {
        return wallets_.get(index);  } else {
        return walletsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public java.util.List<? extends common.grpc.users.WalletMessageOrBuilder> 
         getWalletsOrBuilderList() {
      if (walletsBuilder_ != null) {
        return walletsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(wallets_);
      }
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public common.grpc.users.WalletMessage.Builder addWalletsBuilder() {
      return getWalletsFieldBuilder().addBuilder(
          common.grpc.users.WalletMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public common.grpc.users.WalletMessage.Builder addWalletsBuilder(
        int index) {
      return getWalletsFieldBuilder().addBuilder(
          index, common.grpc.users.WalletMessage.getDefaultInstance());
    }
    /**
     * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
     */
    public java.util.List<common.grpc.users.WalletMessage.Builder> 
         getWalletsBuilderList() {
      return getWalletsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        common.grpc.users.WalletMessage, common.grpc.users.WalletMessage.Builder, common.grpc.users.WalletMessageOrBuilder> 
        getWalletsFieldBuilder() {
      if (walletsBuilder_ == null) {
        walletsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            common.grpc.users.WalletMessage, common.grpc.users.WalletMessage.Builder, common.grpc.users.WalletMessageOrBuilder>(
                wallets_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        wallets_ = null;
      }
      return walletsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:common.grpc.users.AllWalletsResponse)
  }

  // @@protoc_insertion_point(class_scope:common.grpc.users.AllWalletsResponse)
  private static final common.grpc.users.AllWalletsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new common.grpc.users.AllWalletsResponse();
  }

  public static common.grpc.users.AllWalletsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AllWalletsResponse>
      PARSER = new com.google.protobuf.AbstractParser<AllWalletsResponse>() {
    @java.lang.Override
    public AllWalletsResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<AllWalletsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AllWalletsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public common.grpc.users.AllWalletsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

