package ua.lysenko.banking.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.lysenko.banking.card.DTO.CardDTO;
import ua.lysenko.banking.card.models.CardResponseModel;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.wallet.dto.WalletDTO;
import ua.lysenko.banking.wallet.models.WalletResponseModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletMapper mapper = Mappers.getMapper(WalletMapper.class);


    WalletDTO toWalletDTO(Wallet createdWallet);

    WalletResponseModel toWalletResponseModel(WalletDTO walletDTO);

    CardResponseModel toCardResponseModel(CardDTO cardDTO);

    List<CardResponseModel> toCardResponseModels(List<CardDTO> cardDTOs);
}