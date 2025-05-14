package com.deusley.picpay.service.impl;

import com.deusley.picpay.entity.Wallet;
import com.deusley.picpay.repository.WalletRepository;
import com.deusley.picpay.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public Wallet create(Wallet wallet) {

        return walletRepository.save(wallet);
    }
}
