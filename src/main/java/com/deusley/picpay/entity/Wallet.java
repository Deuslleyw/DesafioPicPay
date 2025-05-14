package com.deusley.picpay.entity;

import com.deusley.picpay.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TB_WALLET")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Column(unique = true)
    private String cpfCnpj;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;
    private BigDecimal balance = BigDecimal.ZERO;

    private TypeEnum walletType;
}
