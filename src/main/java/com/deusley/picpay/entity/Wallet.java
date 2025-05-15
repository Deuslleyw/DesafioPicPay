package com.deusley.picpay.entity;

import com.deusley.picpay.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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

    public boolean isTransferAllowedForWalletType() {
        return this.walletType.equals(TypeEnum.USER);

    }

    public boolean isBalancerEqualOrGreatherThan(@DecimalMin("0.01") @NotNull BigDecimal value) {
        return this.balance.doubleValue() >= value.doubleValue();
    }

    public void debit(@DecimalMin("0.01") @NotNull BigDecimal value) {
       this.balance = this.balance.subtract(value);
    }

    public void credit(@DecimalMin("0.01") @NotNull BigDecimal value) {

        this.balance = this.balance.add(value);
    }
}
