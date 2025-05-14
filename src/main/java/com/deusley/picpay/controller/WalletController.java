package com.deusley.picpay.controller;

import com.deusley.picpay.dto.WalletDto;
import com.deusley.picpay.entity.Wallet;
import com.deusley.picpay.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> create(@RequestBody WalletDto walletDto){
        var walletCreate = walletService.create(walletDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(walletCreate);
    }


}
