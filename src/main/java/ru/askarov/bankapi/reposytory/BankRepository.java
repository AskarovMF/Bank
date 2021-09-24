package ru.askarov.bankapi.reposytory;

import org.springframework.stereotype.Repository;
import ru.askarov.bankapi.model.BankAccount;
import ru.askarov.bankapi.model.Card;

import java.util.List;

@Repository
public class BankRepository {
    public List<Card> getAllCardsById(long userId) {
        return null;
    }

    public BankAccount getAccountById(long accountId) {
        return null;
    }

    public void save(Object card) {
    }

    public Card getCardById(long toCard) {
        return null;
    }
}
