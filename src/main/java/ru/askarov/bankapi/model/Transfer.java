package ru.askarov.bankapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Transfer {
    private long toAccount;
    private long toCard;
    private BigDecimal amount;
}
