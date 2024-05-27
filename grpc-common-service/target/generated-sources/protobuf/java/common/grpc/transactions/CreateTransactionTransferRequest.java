// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common-transaction.proto

package common.grpc.transactions;

/**
 * Protobuf type {@code common.grpc.transactions.CreateTransactionTransferRequest}
 */
public final class CreateTransactionTransferRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:common.grpc.transactions.CreateTransactionTransferRequest)
    CreateTransactionTransferRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateTransactionTransferRequest.newBuilder() to construct.
  private CreateTransactionTransferRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateTransactionTransferRequest() {
    token_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateTransactionTransferRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionTransferRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionTransferRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            common.grpc.transactions.CreateTransactionTransferRequest.class, common.grpc.transactions.CreateTransactionTransferRequest.Builder.class);
  }

  public static final int TOKEN_FIELD_NUMBER = 1;
  private volatile java.lang.Object token_;
  /**
   * <code>string token = 1;</code>
   * @return The token.
   */
  @java.lang.Override
  public java.lang.String getToken() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>string token = 1;</code>
   * @return The bytes for token.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTokenBytes() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      token_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AMOUNT_FIELD_NUMBER = 2;
  private float amount_;
  /**
   * <code>float amount = 2;</code>
   * @return The amount.
   */
  @java.lang.Override
  public float getAmount() {
    return amount_;
  }

  public static final int CARD_ID_FIELD_NUMBER = 3;
  private long cardId_;
  /**
   * <code>int64 card_id = 3;</code>
   * @return The cardId.
   */
  @java.lang.Override
  public long getCardId() {
    return cardId_;
  }

  public static final int RECEIVER_CARD_ID_FIELD_NUMBER = 4;
  private long receiverCardId_;
  /**
   * <code>int64 receiver_card_id = 4;</code>
   * @return The receiverCardId.
   */
  @java.lang.Override
  public long getReceiverCardId() {
    return receiverCardId_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(token_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, token_);
    }
    if (java.lang.Float.floatToRawIntBits(amount_) != 0) {
      output.writeFloat(2, amount_);
    }
    if (cardId_ != 0L) {
      output.writeInt64(3, cardId_);
    }
    if (receiverCardId_ != 0L) {
      output.writeInt64(4, receiverCardId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(token_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, token_);
    }
    if (java.lang.Float.floatToRawIntBits(amount_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, amount_);
    }
    if (cardId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, cardId_);
    }
    if (receiverCardId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, receiverCardId_);
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
    if (!(obj instanceof common.grpc.transactions.CreateTransactionTransferRequest)) {
      return super.equals(obj);
    }
    common.grpc.transactions.CreateTransactionTransferRequest other = (common.grpc.transactions.CreateTransactionTransferRequest) obj;

    if (!getToken()
        .equals(other.getToken())) return false;
    if (java.lang.Float.floatToIntBits(getAmount())
        != java.lang.Float.floatToIntBits(
            other.getAmount())) return false;
    if (getCardId()
        != other.getCardId()) return false;
    if (getReceiverCardId()
        != other.getReceiverCardId()) return false;
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
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getAmount());
    hash = (37 * hash) + CARD_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCardId());
    hash = (37 * hash) + RECEIVER_CARD_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getReceiverCardId());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.transactions.CreateTransactionTransferRequest parseFrom(
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
  public static Builder newBuilder(common.grpc.transactions.CreateTransactionTransferRequest prototype) {
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
   * Protobuf type {@code common.grpc.transactions.CreateTransactionTransferRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:common.grpc.transactions.CreateTransactionTransferRequest)
      common.grpc.transactions.CreateTransactionTransferRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionTransferRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionTransferRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              common.grpc.transactions.CreateTransactionTransferRequest.class, common.grpc.transactions.CreateTransactionTransferRequest.Builder.class);
    }

    // Construct using common.grpc.transactions.CreateTransactionTransferRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      token_ = "";

      amount_ = 0F;

      cardId_ = 0L;

      receiverCardId_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionTransferRequest_descriptor;
    }

    @java.lang.Override
    public common.grpc.transactions.CreateTransactionTransferRequest getDefaultInstanceForType() {
      return common.grpc.transactions.CreateTransactionTransferRequest.getDefaultInstance();
    }

    @java.lang.Override
    public common.grpc.transactions.CreateTransactionTransferRequest build() {
      common.grpc.transactions.CreateTransactionTransferRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public common.grpc.transactions.CreateTransactionTransferRequest buildPartial() {
      common.grpc.transactions.CreateTransactionTransferRequest result = new common.grpc.transactions.CreateTransactionTransferRequest(this);
      result.token_ = token_;
      result.amount_ = amount_;
      result.cardId_ = cardId_;
      result.receiverCardId_ = receiverCardId_;
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
      if (other instanceof common.grpc.transactions.CreateTransactionTransferRequest) {
        return mergeFrom((common.grpc.transactions.CreateTransactionTransferRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(common.grpc.transactions.CreateTransactionTransferRequest other) {
      if (other == common.grpc.transactions.CreateTransactionTransferRequest.getDefaultInstance()) return this;
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
        onChanged();
      }
      if (other.getAmount() != 0F) {
        setAmount(other.getAmount());
      }
      if (other.getCardId() != 0L) {
        setCardId(other.getCardId());
      }
      if (other.getReceiverCardId() != 0L) {
        setReceiverCardId(other.getReceiverCardId());
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
              token_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 21: {
              amount_ = input.readFloat();

              break;
            } // case 21
            case 24: {
              cardId_ = input.readInt64();

              break;
            } // case 24
            case 32: {
              receiverCardId_ = input.readInt64();

              break;
            } // case 32
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

    private java.lang.Object token_ = "";
    /**
     * <code>string token = 1;</code>
     * @return The token.
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string token = 1;</code>
     * @return The bytes for token.
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string token = 1;</code>
     * @param value The token to set.
     * @return This builder for chaining.
     */
    public Builder setToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      token_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string token = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearToken() {
      
      token_ = getDefaultInstance().getToken();
      onChanged();
      return this;
    }
    /**
     * <code>string token = 1;</code>
     * @param value The bytes for token to set.
     * @return This builder for chaining.
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      token_ = value;
      onChanged();
      return this;
    }

    private float amount_ ;
    /**
     * <code>float amount = 2;</code>
     * @return The amount.
     */
    @java.lang.Override
    public float getAmount() {
      return amount_;
    }
    /**
     * <code>float amount = 2;</code>
     * @param value The amount to set.
     * @return This builder for chaining.
     */
    public Builder setAmount(float value) {
      
      amount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float amount = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAmount() {
      
      amount_ = 0F;
      onChanged();
      return this;
    }

    private long cardId_ ;
    /**
     * <code>int64 card_id = 3;</code>
     * @return The cardId.
     */
    @java.lang.Override
    public long getCardId() {
      return cardId_;
    }
    /**
     * <code>int64 card_id = 3;</code>
     * @param value The cardId to set.
     * @return This builder for chaining.
     */
    public Builder setCardId(long value) {
      
      cardId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 card_id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCardId() {
      
      cardId_ = 0L;
      onChanged();
      return this;
    }

    private long receiverCardId_ ;
    /**
     * <code>int64 receiver_card_id = 4;</code>
     * @return The receiverCardId.
     */
    @java.lang.Override
    public long getReceiverCardId() {
      return receiverCardId_;
    }
    /**
     * <code>int64 receiver_card_id = 4;</code>
     * @param value The receiverCardId to set.
     * @return This builder for chaining.
     */
    public Builder setReceiverCardId(long value) {
      
      receiverCardId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 receiver_card_id = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearReceiverCardId() {
      
      receiverCardId_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:common.grpc.transactions.CreateTransactionTransferRequest)
  }

  // @@protoc_insertion_point(class_scope:common.grpc.transactions.CreateTransactionTransferRequest)
  private static final common.grpc.transactions.CreateTransactionTransferRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new common.grpc.transactions.CreateTransactionTransferRequest();
  }

  public static common.grpc.transactions.CreateTransactionTransferRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateTransactionTransferRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateTransactionTransferRequest>() {
    @java.lang.Override
    public CreateTransactionTransferRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<CreateTransactionTransferRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateTransactionTransferRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public common.grpc.transactions.CreateTransactionTransferRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
