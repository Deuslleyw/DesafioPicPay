package com.deusley.picpay.entity;

import com.deusley.picpay.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.*;

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
    private TypeEnum typeEnum;

}


