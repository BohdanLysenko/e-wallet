// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common-transaction.proto

package common.grpc.transactions;

/**
 * Protobuf type {@code common.grpc.transactions.CreateTransactionRequest}
 */
public final class CreateTransactionRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:common.grpc.transactions.CreateTransactionRequest)
    CreateTransactionRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateTransactionRequest.newBuilder() to construct.
  private CreateTransactionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateTransactionRequest() {
    token_ = "";
    transactionType_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateTransactionRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            common.grpc.transactions.CreateTransactionRequest.class, common.grpc.transactions.CreateTransactionRequest.Builder.class);
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

  public static final int TRANSACTION_TYPE_FIELD_NUMBER = 4;
  private volatile java.lang.Object transactionType_;
  /**
   * <code>string transaction_type = 4;</code>
   * @return The transactionType.
   */
  @java.lang.Override
  public java.lang.String getTransactionType() {
    java.lang.Object ref = transactionType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      transactionType_ = s;
      return s;
    }
  }
  /**
   * <code>string transaction_type = 4;</code>
   * @return The bytes for transactionType.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTransactionTypeBytes() {
    java.lang.Object ref = transactionType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      transactionType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(transactionType_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, transactionType_);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(transactionType_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, transactionType_);
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
    if (!(obj instanceof common.grpc.transactions.CreateTransactionRequest)) {
      return super.equals(obj);
    }
    common.grpc.transactions.CreateTransactionRequest other = (common.grpc.transactions.CreateTransactionRequest) obj;

    if (!getToken()
        .equals(other.getToken())) return false;
    if (java.lang.Float.floatToIntBits(getAmount())
        != java.lang.Float.floatToIntBits(
            other.getAmount())) return false;
    if (getCardId()
        != other.getCardId()) return false;
    if (!getTransactionType()
        .equals(other.getTransactionType())) return false;
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
    hash = (37 * hash) + TRANSACTION_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getTransactionType().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.transactions.CreateTransactionRequest parseFrom(
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
  public static Builder newBuilder(common.grpc.transactions.CreateTransactionRequest prototype) {
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
   * Protobuf type {@code common.grpc.transactions.CreateTransactionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:common.grpc.transactions.CreateTransactionRequest)
      common.grpc.transactions.CreateTransactionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              common.grpc.transactions.CreateTransactionRequest.class, common.grpc.transactions.CreateTransactionRequest.Builder.class);
    }

    // Construct using common.grpc.transactions.CreateTransactionRequest.newBuilder()
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

      transactionType_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return common.grpc.transactions.CommonTransaction.internal_static_common_grpc_transactions_CreateTransactionRequest_descriptor;
    }

    @java.lang.Override
    public common.grpc.transactions.CreateTransactionRequest getDefaultInstanceForType() {
      return common.grpc.transactions.CreateTransactionRequest.getDefaultInstance();
    }

    @java.lang.Override
    public common.grpc.transactions.CreateTransactionRequest build() {
      common.grpc.transactions.CreateTransactionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public common.grpc.transactions.CreateTransactionRequest buildPartial() {
      common.grpc.transactions.CreateTransactionRequest result = new common.grpc.transactions.CreateTransactionRequest(this);
      result.token_ = token_;
      result.amount_ = amount_;
      result.cardId_ = cardId_;
      result.transactionType_ = transactionType_;
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
      if (other instanceof common.grpc.transactions.CreateTransactionRequest) {
        return mergeFrom((common.grpc.transactions.CreateTransactionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(common.grpc.transactions.CreateTransactionRequest other) {
      if (other == common.grpc.transactions.CreateTransactionRequest.getDefaultInstance()) return this;
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
      if (!other.getTransactionType().isEmpty()) {
        transactionType_ = other.transactionType_;
        onChanged();
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
            case 34: {
              transactionType_ = input.readStringRequireUtf8();

              break;
            } // case 34
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

    private java.lang.Object transactionType_ = "";
    /**
     * <code>string transaction_type = 4;</code>
     * @return The transactionType.
     */
    public java.lang.String getTransactionType() {
      java.lang.Object ref = transactionType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        transactionType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string transaction_type = 4;</code>
     * @return The bytes for transactionType.
     */
    public com.google.protobuf.ByteString
        getTransactionTypeBytes() {
      java.lang.Object ref = transactionType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        transactionType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string transaction_type = 4;</code>
     * @param value The transactionType to set.
     * @return This builder for chaining.
     */
    public Builder setTransactionType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      transactionType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string transaction_type = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearTransactionType() {
      
      transactionType_ = getDefaultInstance().getTransactionType();
      onChanged();
      return this;
    }
    /**
     * <code>string transaction_type = 4;</code>
     * @param value The bytes for transactionType to set.
     * @return This builder for chaining.
     */
    public Builder setTransactionTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      transactionType_ = value;
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


    // @@protoc_insertion_point(builder_scope:common.grpc.transactions.CreateTransactionRequest)
  }

  // @@protoc_insertion_point(class_scope:common.grpc.transactions.CreateTransactionRequest)
  private static final common.grpc.transactions.CreateTransactionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new common.grpc.transactions.CreateTransactionRequest();
  }

  public static common.grpc.transactions.CreateTransactionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateTransactionRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateTransactionRequest>() {
    @java.lang.Override
    public CreateTransactionRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<CreateTransactionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateTransactionRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public common.grpc.transactions.CreateTransactionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
