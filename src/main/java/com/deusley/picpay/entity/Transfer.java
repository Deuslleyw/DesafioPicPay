package com.deusley.picpay.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
@Data
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    private BigDecimal balance;

    public Transfer(Wallet sender, Wallet receiver, BigDecimal balance) {
        this.sender = sender;
        this.receiver = receiver;
        this.balance = balance;
    }
}
