// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package common.grpc.users;

public interface AllWalletsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:common.grpc.users.AllWalletsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  java.util.List<common.grpc.users.WalletMessage> 
      getWalletsList();
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  common.grpc.users.WalletMessage getWallets(int index);
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  int getWalletsCount();
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  java.util.List<? extends common.grpc.users.WalletMessageOrBuilder> 
      getWalletsOrBuilderList();
  /**
   * <code>repeated .common.grpc.users.WalletMessage wallets = 1;</code>
   */
  common.grpc.users.WalletMessageOrBuilder getWalletsOrBuilder(
      int index);
}
