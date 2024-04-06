package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null && !users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (users.get(findByPassport(passport)) != null) {
            for (Account account : users.get(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        if (findByRequisite(sourcePassport, sourceRequisite) != null
                && findByRequisite(destinationPassport, destinationRequisite) != null
                && findByRequisite(sourcePassport, sourceRequisite).getBalance() >= amount) {
            findByRequisite(sourcePassport, sourceRequisite).setBalance(findByRequisite(sourcePassport, sourceRequisite).getBalance() - amount);
            findByRequisite(destinationPassport, destinationRequisite).setBalance(findByRequisite(destinationPassport, destinationRequisite).getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
