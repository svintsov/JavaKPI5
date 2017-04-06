package com.bazyl.credits.model;

import java.util.HashSet;
import java.util.Set;

public class Portfolio {
    Set<Bank> banks;

    Portfolio() {
        banks = new HashSet<Bank>();
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public void deleteBank(Bank bank) {
        banks.remove(bank);
    }

    public Bank getBankByID(int id) throws ItemNotFoundException {
        for (Bank bank : banks) {
            if (bank.getId() == id) {
                return bank;
            }
        }
        throw new ItemNotFoundException();
    }
}
