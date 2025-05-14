package com.deusley.picpay.controller;

import com.deusley.picpay.entity.Wallet;
import com.deusley.picpay.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> create(Wallet wallet){
        var walletCreate = walletService.create(wallet);
        return ResponseEntity.status(HttpStatus.CREATED).body(walletCreate);
    }


}
