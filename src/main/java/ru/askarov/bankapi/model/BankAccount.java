package ru.askarov.bankapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class BankAccount {
    private long accountId;
    private BigDecimal amount;
}
