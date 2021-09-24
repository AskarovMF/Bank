package ru.askarov.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.askarov.bankapi.model.BankAccount;
import ru.askarov.bankapi.model.Card;
import ru.askarov.bankapi.model.Transfer;
import ru.askarov.bankapi.reposytory.BankRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final BankRepository bankRepository;

    @Autowired
    public AccountService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Card> getCardsById(long userId) {
        return bankRepository.getAllCardsById(userId);
    }

    public void addCardByAccountId(long accountId) {
        BankAccount bankAccount = bankRepository.getAccountById(accountId);
        if (bankAccount == null) throw new IllegalArgumentException("Account not exist");
        else {
            Card card = new Card(accountId);
            bankRepository.save(card);
        }
    }

    public void makeTransfer(Transfer transfer) {
        if (transfer.getToAccount() == 0){
            Card cardTo = bankRepository.getCardById(transfer.getToCard());
            topUpCard(cardTo, transfer.getAmount());
        } else if (transfer.getToCard() == 0){
            BankAccount accountTo = bankRepository.getAccountById(transfer.getToAccount());
            topUpAccount(accountTo, transfer.getAmount());
        }
    }

    private void topUpCard(Card cardTo, BigDecimal amount) {
        Card card = bankRepository.getCardById(cardTo.getCardId());
        card.getAmount().add(amount);
        bankRepository.save(card);
    }

    private void topUpAccount(BankAccount accountTo, BigDecimal amount) {
        BankAccount account = bankRepository.getAccountById(accountTo.getAccountId());
        account.getAmount().add(amount);
        bankRepository.save(account);
    }
}
