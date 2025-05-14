package com.deusley.picpay.mapper;

import com.deusley.picpay.dto.WalletDto;
import com.deusley.picpay.entity.Wallet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    Wallet toWallet(WalletDto walletDto);

    WalletDto fromWallet(Wallet wallet);

}
