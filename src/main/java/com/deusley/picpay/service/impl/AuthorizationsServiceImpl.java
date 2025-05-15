package com.deusley.picpay.service.impl;

import com.deusley.picpay.clients.AuthorizationClient;
import com.deusley.picpay.dto.TransferDto;
import com.deusley.picpay.service.AuthorizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationsServiceImpl implements AuthorizationsService {


    @Autowired
    private AuthorizationClient authorizationClient;

    @Override
    public boolean isAuthorized(TransferDto transfer) {

        var responseClient = authorizationClient.isAuthorized();
        if (responseClient.getStatusCode().isError()) {
            throw new RuntimeException("ERRO NA TRANSAçÂO");
        }


        return responseClient.getBody().authorized();


    }
}