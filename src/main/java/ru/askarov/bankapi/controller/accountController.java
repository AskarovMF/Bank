package ru.askarov.bankapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.askarov.bankapi.model.Card;
import ru.askarov.bankapi.model.Transfer;
import ru.askarov.bankapi.service.AccountService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RestController("/account")
public class accountController {
    private final AccountService accountService;

    @Autowired
    public accountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/allCards/{userId}")
    public List<Card> getCards(@PathVariable long userId){
        return accountService.getCardsById(userId);
    }

    @PostMapping("/addCard/{accountId}")
    public void addCard(@PathVariable long accountId){
        accountService.addCardByAccountId(accountId);
    }

    @PatchMapping("/topUpAccount")
    public void topUpAccount(@RequestBody Transfer transfer){
        accountService.makeTransfer(transfer);
    }
}
