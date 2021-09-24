package ru.askarov.bankapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Card {
    private long cardId;
    private BigDecimal amount;
    private BankAccount account;


}
