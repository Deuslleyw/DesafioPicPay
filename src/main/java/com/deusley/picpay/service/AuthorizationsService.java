package com.deusley.picpay.service;


import com.deusley.picpay.entity.Transfer;

public interface AuthorizationsService {

    public boolean isAuthorized(Transfer transfer);



}
