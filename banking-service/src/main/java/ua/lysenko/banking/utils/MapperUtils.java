package ua.lysenko.banking.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import ua.lysenko.banking.entity.Wallet;
import ua.lysenko.banking.wallet.dto.WalletDTO;

@Component
public class MapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        typeMapWalletWalletDTO();
    }

    public static <T, U> U map(T source, Class<U> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    private static void typeMapWalletWalletDTO() {
        modelMapper.typeMap(Wallet.class, WalletDTO.class)
                .addMappings(mapper -> mapper.using(Converters.UUID_TO_STRING_CONVERTER)
                        .map(Wallet::getWalletNumber, WalletDTO::setWalletNumber));
    }
}