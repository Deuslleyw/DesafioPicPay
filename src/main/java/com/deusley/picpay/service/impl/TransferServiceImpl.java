package com.deusley.picpay.service.impl;

import com.deusley.picpay.dto.TransferDto;
import com.deusley.picpay.entity.Transfer;
import com.deusley.picpay.entity.Wallet;
import com.deusley.picpay.repository.TransferRepository;
import com.deusley.picpay.repository.WalletRepository;
import com.deusley.picpay.service.AuthorizationsService;
import com.deusley.picpay.service.NotificationService;
import com.deusley.picpay.service.TransferService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AuthorizationsService authorizationsService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletRepository walletRepository;


    @Override
    @Transactional
    public Transfer transfer(TransferDto transferDto) {

       var sender =  walletRepository.findById(transferDto.payer())
                .orElseThrow(() -> new RuntimeException("CARTEIRA NÂO EXISTENTE (walletNotFound)"));

        var receiver =  walletRepository.findById(transferDto.payee())
                .orElseThrow(() -> new RuntimeException("CARTEIRA NÂO EXISTENTE (walletNotFound)"));

        validateTransfer(transferDto, sender);

        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new Transfer(sender,receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(()-> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDto transferDto, Wallet sender) {

        if(!sender.isTransferAllowedForWalletType()){
            throw new RuntimeException("Transferencia Não Permitida (TransferNotAllowedForWalletType)");
        }
        if(!sender.isBalancerEqualOrGreatherThan(transferDto.value())){
            throw new RuntimeException("InsufficientBalance  (Saldo Insuficiente)");

        }
        if(authorizationsService.isAuthorized(transferDto)){
            throw new RuntimeException("Transfer not authorized");     }

    }
}
