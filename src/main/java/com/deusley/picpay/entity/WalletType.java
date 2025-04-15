package com.deusley.picpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_WALLET_TYPE")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @AllArgsConstructor
    public enum enuns{

        USER(1L, "user"),
        MERCHANT(2L, "merchant");


        private final Long id;
        private final String description;

        private WalletType get(){
            return new WalletType(id, description);
        }


    }



}
