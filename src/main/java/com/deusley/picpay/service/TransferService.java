package com.deusley.picpay.service;

import com.deusley.picpay.dto.TransferDto;
import com.deusley.picpay.entity.Transfer;

public interface TransferService {

    Transfer transfer(TransferDto transferDto);

}
