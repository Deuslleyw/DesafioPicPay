package com.deusley.picpay.service.impl;

import com.deusley.picpay.clients.AuthorizationClient;
import com.deusley.picpay.entity.Transfer;
import com.deusley.picpay.service.AuthorizationsService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationsServiceImpl implements AuthorizationsService {


    private final AuthorizationClient authorizationClient;

    public AuthorizationsServiceImpl(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }


    @Override
    public boolean isAuthorized(Transfer transfer) {

        var responseClient =  authorizationClient.isAuthorized();
        if (responseClient.getStatusCode().isError()){
            throw new RuntimeException("ERRO NA TRANSAçÂO");
        }


        return responseClient.getBody().authorized();
    }
}



