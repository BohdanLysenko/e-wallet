package ua.lysenko.banking.utils.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.wallet.dto.WalletDTO;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletMapper mapper = Mappers.getMapper(WalletMapper.class);


    WalletDTO toWalletDTO(Wallet createdWallet);
}