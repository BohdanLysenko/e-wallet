// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common-transaction.proto

package common.grpc.transactions;

public interface CreateTransactionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:common.grpc.transactions.CreateTransactionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string token = 1;</code>
   * @return The token.
   */
  java.lang.String getToken();
  /**
   * <code>string token = 1;</code>
   * @return The bytes for token.
   */
  com.google.protobuf.ByteString
      getTokenBytes();

  /**
   * <code>float amount = 2;</code>
   * @return The amount.
   */
  float getAmount();

  /**
   * <code>int64 card_id = 3;</code>
   * @return The cardId.
   */
  long getCardId();

  /**
   * <code>string transaction_type = 4;</code>
   * @return The transactionType.
   */
  java.lang.String getTransactionType();
  /**
   * <code>string transaction_type = 4;</code>
   * @return The bytes for transactionType.
   */
  com.google.protobuf.ByteString
      getTransactionTypeBytes();
}
