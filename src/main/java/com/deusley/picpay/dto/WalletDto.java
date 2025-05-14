package com.deusley.picpay.dto;

import com.deusley.picpay.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class WalletDto {

    private String fullName;
    private String cpfCnpj;
    private String email;
    private String password;
    private TypeEnum walletType;
}


