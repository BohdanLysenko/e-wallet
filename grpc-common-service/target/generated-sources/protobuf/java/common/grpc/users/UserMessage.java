// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: users.proto

package common.grpc.users;

/**
 * Protobuf type {@code common.grpc.users.UserMessage}
 */
public final class UserMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:common.grpc.users.UserMessage)
    UserMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserMessage.newBuilder() to construct.
  private UserMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserMessage() {
    email_ = "";
    role_ = "";
    firstName_ = "";
    lastName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UserMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return common.grpc.users.Users.internal_static_common_grpc_users_UserMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return common.grpc.users.Users.internal_static_common_grpc_users_UserMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            common.grpc.users.UserMessage.class, common.grpc.users.UserMessage.Builder.class);
  }

  public static final int EMAIL_FIELD_NUMBER = 1;
  private volatile java.lang.Object email_;
  /**
   * <code>string email = 1;</code>
   * @return The email.
   */
  @java.lang.Override
  public java.lang.String getEmail() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      email_ = s;
      return s;
    }
  }
  /**
   * <code>string email = 1;</code>
   * @return The bytes for email.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getEmailBytes() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      email_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRANSACTION_BLOCKED_FIELD_NUMBER = 2;
  private boolean transactionBlocked_;
  /**
   * <code>bool transaction_blocked = 2;</code>
   * @return The transactionBlocked.
   */
  @java.lang.Override
  public boolean getTransactionBlocked() {
    return transactionBlocked_;
  }

  public static final int ID_FIELD_NUMBER = 3;
  private long id_;
  /**
   * <code>int64 id = 3;</code>
   * @return The id.
   */
  @java.lang.Override
  public long getId() {
    return id_;
  }

  public static final int ROLE_FIELD_NUMBER = 4;
  private volatile java.lang.Object role_;
  /**
   * <code>string role = 4;</code>
   * @return The role.
   */
  @java.lang.Override
  public java.lang.String getRole() {
    java.lang.Object ref = role_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      role_ = s;
      return s;
    }
  }
  /**
   * <code>string role = 4;</code>
   * @return The bytes for role.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRoleBytes() {
    java.lang.Object ref = role_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      role_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FIRST_NAME_FIELD_NUMBER = 5;
  private volatile java.lang.Object firstName_;
  /**
   * <code>string first_name = 5;</code>
   * @return The firstName.
   */
  @java.lang.Override
  public java.lang.String getFirstName() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      firstName_ = s;
      return s;
    }
  }
  /**
   * <code>string first_name = 5;</code>
   * @return The bytes for firstName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFirstNameBytes() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      firstName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LAST_NAME_FIELD_NUMBER = 6;
  private volatile java.lang.Object lastName_;
  /**
   * <code>string last_name = 6;</code>
   * @return The lastName.
   */
  @java.lang.Override
  public java.lang.String getLastName() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastName_ = s;
      return s;
    }
  }
  /**
   * <code>string last_name = 6;</code>
   * @return The bytes for lastName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SUSPICIOUS_ACTIVITY_DETECTED_FIELD_NUMBER = 7;
  private boolean suspiciousActivityDetected_;
  /**
   * <code>bool suspicious_activity_detected = 7;</code>
   * @return The suspiciousActivityDetected.
   */
  @java.lang.Override
  public boolean getSuspiciousActivityDetected() {
    return suspiciousActivityDetected_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(email_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, email_);
    }
    if (transactionBlocked_ != false) {
      output.writeBool(2, transactionBlocked_);
    }
    if (id_ != 0L) {
      output.writeInt64(3, id_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(role_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, role_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(firstName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, firstName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, lastName_);
    }
    if (suspiciousActivityDetected_ != false) {
      output.writeBool(7, suspiciousActivityDetected_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(email_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, email_);
    }
    if (transactionBlocked_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, transactionBlocked_);
    }
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, id_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(role_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, role_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(firstName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, firstName_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(lastName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, lastName_);
    }
    if (suspiciousActivityDetected_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(7, suspiciousActivityDetected_);
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
    if (!(obj instanceof common.grpc.users.UserMessage)) {
      return super.equals(obj);
    }
    common.grpc.users.UserMessage other = (common.grpc.users.UserMessage) obj;

    if (!getEmail()
        .equals(other.getEmail())) return false;
    if (getTransactionBlocked()
        != other.getTransactionBlocked()) return false;
    if (getId()
        != other.getId()) return false;
    if (!getRole()
        .equals(other.getRole())) return false;
    if (!getFirstName()
        .equals(other.getFirstName())) return false;
    if (!getLastName()
        .equals(other.getLastName())) return false;
    if (getSuspiciousActivityDetected()
        != other.getSuspiciousActivityDetected()) return false;
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
    hash = (37 * hash) + EMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getEmail().hashCode();
    hash = (37 * hash) + TRANSACTION_BLOCKED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getTransactionBlocked());
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + ROLE_FIELD_NUMBER;
    hash = (53 * hash) + getRole().hashCode();
    hash = (37 * hash) + FIRST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getFirstName().hashCode();
    hash = (37 * hash) + LAST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastName().hashCode();
    hash = (37 * hash) + SUSPICIOUS_ACTIVITY_DETECTED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSuspiciousActivityDetected());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static common.grpc.users.UserMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.UserMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.UserMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.UserMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.UserMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static common.grpc.users.UserMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static common.grpc.users.UserMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.UserMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.UserMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static common.grpc.users.UserMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static common.grpc.users.UserMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static common.grpc.users.UserMessage parseFrom(
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
  public static Builder newBuilder(common.grpc.users.UserMessage prototype) {
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
   * Protobuf type {@code common.grpc.users.UserMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:common.grpc.users.UserMessage)
      common.grpc.users.UserMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return common.grpc.users.Users.internal_static_common_grpc_users_UserMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return common.grpc.users.Users.internal_static_common_grpc_users_UserMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              common.grpc.users.UserMessage.class, common.grpc.users.UserMessage.Builder.class);
    }

    // Construct using common.grpc.users.UserMessage.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      email_ = "";

      transactionBlocked_ = false;

      id_ = 0L;

      role_ = "";

      firstName_ = "";

      lastName_ = "";

      suspiciousActivityDetected_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return common.grpc.users.Users.internal_static_common_grpc_users_UserMessage_descriptor;
    }

    @java.lang.Override
    public common.grpc.users.UserMessage getDefaultInstanceForType() {
      return common.grpc.users.UserMessage.getDefaultInstance();
    }

    @java.lang.Override
    public common.grpc.users.UserMessage build() {
      common.grpc.users.UserMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public common.grpc.users.UserMessage buildPartial() {
      common.grpc.users.UserMessage result = new common.grpc.users.UserMessage(this);
      result.email_ = email_;
      result.transactionBlocked_ = transactionBlocked_;
      result.id_ = id_;
      result.role_ = role_;
      result.firstName_ = firstName_;
      result.lastName_ = lastName_;
      result.suspiciousActivityDetected_ = suspiciousActivityDetected_;
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
      if (other instanceof common.grpc.users.UserMessage) {
        return mergeFrom((common.grpc.users.UserMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(common.grpc.users.UserMessage other) {
      if (other == common.grpc.users.UserMessage.getDefaultInstance()) return this;
      if (!other.getEmail().isEmpty()) {
        email_ = other.email_;
        onChanged();
      }
      if (other.getTransactionBlocked() != false) {
        setTransactionBlocked(other.getTransactionBlocked());
      }
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (!other.getRole().isEmpty()) {
        role_ = other.role_;
        onChanged();
      }
      if (!other.getFirstName().isEmpty()) {
        firstName_ = other.firstName_;
        onChanged();
      }
      if (!other.getLastName().isEmpty()) {
        lastName_ = other.lastName_;
        onChanged();
      }
      if (other.getSuspiciousActivityDetected() != false) {
        setSuspiciousActivityDetected(other.getSuspiciousActivityDetected());
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
              email_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 16: {
              transactionBlocked_ = input.readBool();

              break;
            } // case 16
            case 24: {
              id_ = input.readInt64();

              break;
            } // case 24
            case 34: {
              role_ = input.readStringRequireUtf8();

              break;
            } // case 34
            case 42: {
              firstName_ = input.readStringRequireUtf8();

              break;
            } // case 42
            case 50: {
              lastName_ = input.readStringRequireUtf8();

              break;
            } // case 50
            case 56: {
              suspiciousActivityDetected_ = input.readBool();

              break;
            } // case 56
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

    private java.lang.Object email_ = "";
    /**
     * <code>string email = 1;</code>
     * @return The email.
     */
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        email_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string email = 1;</code>
     * @return The bytes for email.
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string email = 1;</code>
     * @param value The email to set.
     * @return This builder for chaining.
     */
    public Builder setEmail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      email_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string email = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearEmail() {
      
      email_ = getDefaultInstance().getEmail();
      onChanged();
      return this;
    }
    /**
     * <code>string email = 1;</code>
     * @param value The bytes for email to set.
     * @return This builder for chaining.
     */
    public Builder setEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      email_ = value;
      onChanged();
      return this;
    }

    private boolean transactionBlocked_ ;
    /**
     * <code>bool transaction_blocked = 2;</code>
     * @return The transactionBlocked.
     */
    @java.lang.Override
    public boolean getTransactionBlocked() {
      return transactionBlocked_;
    }
    /**
     * <code>bool transaction_blocked = 2;</code>
     * @param value The transactionBlocked to set.
     * @return This builder for chaining.
     */
    public Builder setTransactionBlocked(boolean value) {
      
      transactionBlocked_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool transaction_blocked = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTransactionBlocked() {
      
      transactionBlocked_ = false;
      onChanged();
      return this;
    }

    private long id_ ;
    /**
     * <code>int64 id = 3;</code>
     * @return The id.
     */
    @java.lang.Override
    public long getId() {
      return id_;
    }
    /**
     * <code>int64 id = 3;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object role_ = "";
    /**
     * <code>string role = 4;</code>
     * @return The role.
     */
    public java.lang.String getRole() {
      java.lang.Object ref = role_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        role_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string role = 4;</code>
     * @return The bytes for role.
     */
    public com.google.protobuf.ByteString
        getRoleBytes() {
      java.lang.Object ref = role_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        role_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string role = 4;</code>
     * @param value The role to set.
     * @return This builder for chaining.
     */
    public Builder setRole(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      role_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string role = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearRole() {
      
      role_ = getDefaultInstance().getRole();
      onChanged();
      return this;
    }
    /**
     * <code>string role = 4;</code>
     * @param value The bytes for role to set.
     * @return This builder for chaining.
     */
    public Builder setRoleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      role_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object firstName_ = "";
    /**
     * <code>string first_name = 5;</code>
     * @return The firstName.
     */
    public java.lang.String getFirstName() {
      java.lang.Object ref = firstName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string first_name = 5;</code>
     * @return The bytes for firstName.
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      java.lang.Object ref = firstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string first_name = 5;</code>
     * @param value The firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      firstName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string first_name = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearFirstName() {
      
      firstName_ = getDefaultInstance().getFirstName();
      onChanged();
      return this;
    }
    /**
     * <code>string first_name = 5;</code>
     * @param value The bytes for firstName to set.
     * @return This builder for chaining.
     */
    public Builder setFirstNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      firstName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object lastName_ = "";
    /**
     * <code>string last_name = 6;</code>
     * @return The lastName.
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string last_name = 6;</code>
     * @return The bytes for lastName.
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string last_name = 6;</code>
     * @param value The lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      lastName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string last_name = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearLastName() {
      
      lastName_ = getDefaultInstance().getLastName();
      onChanged();
      return this;
    }
    /**
     * <code>string last_name = 6;</code>
     * @param value The bytes for lastName to set.
     * @return This builder for chaining.
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      lastName_ = value;
      onChanged();
      return this;
    }

    private boolean suspiciousActivityDetected_ ;
    /**
     * <code>bool suspicious_activity_detected = 7;</code>
     * @return The suspiciousActivityDetected.
     */
    @java.lang.Override
    public boolean getSuspiciousActivityDetected() {
      return suspiciousActivityDetected_;
    }
    /**
     * <code>bool suspicious_activity_detected = 7;</code>
     * @param value The suspiciousActivityDetected to set.
     * @return This builder for chaining.
     */
    public Builder setSuspiciousActivityDetected(boolean value) {
      
      suspiciousActivityDetected_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool suspicious_activity_detected = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearSuspiciousActivityDetected() {
      
      suspiciousActivityDetected_ = false;
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


    // @@protoc_insertion_point(builder_scope:common.grpc.users.UserMessage)
  }

  // @@protoc_insertion_point(class_scope:common.grpc.users.UserMessage)
  private static final common.grpc.users.UserMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new common.grpc.users.UserMessage();
  }

  public static common.grpc.users.UserMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserMessage>
      PARSER = new com.google.protobuf.AbstractParser<UserMessage>() {
    @java.lang.Override
    public UserMessage parsePartialFrom(
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

  public static com.google.protobuf.Parser<UserMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public common.grpc.users.UserMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
