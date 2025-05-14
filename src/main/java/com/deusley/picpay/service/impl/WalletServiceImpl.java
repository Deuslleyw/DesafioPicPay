package com.deusley.picpay.service.impl;

import com.deusley.picpay.dto.WalletDto;
import com.deusley.picpay.entity.Wallet;
import com.deusley.picpay.mapper.WalletMapper;
import com.deusley.picpay.repository.WalletRepository;
import com.deusley.picpay.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletMapper walletMapper;


    @Override
    public Wallet create(WalletDto walletDto) {

        var convertedWallet = walletMapper.toWallet(walletDto);
        return walletRepository.save(convertedWallet);
    }
}
