package com.deusley.picpay.service;


import com.deusley.picpay.dto.TransferDto;

public interface AuthorizationsService {

    public boolean isAuthorized(TransferDto transfer);



}
