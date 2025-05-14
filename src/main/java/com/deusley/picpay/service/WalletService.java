package com.deusley.picpay.service;

import com.deusley.picpay.dto.WalletDto;
import com.deusley.picpay.entity.Wallet;

public interface WalletService {



    Wallet create (WalletDto walletDto);

}
