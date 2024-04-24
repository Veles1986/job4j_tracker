package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет собой банковский сервис
 * Позволяет связывать между собой клиентов банка и их банковские карты
 * Есть возможность добавления и удаления пользователя, поиск по паспорту,
 * добавления банковской карту поиск банковской карту по номеру, а также перевода
 * денежных средств с карты на карту
 * @author Veles1986
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о всех клиентах банка в виде HashMap
     * Ключом является класс {@link User}
     * Значением явлюяется {@link ArrayList} из {@link Account}
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в список клиентов банка нового клиента {@link User}
     * У добавленного клиента создаётся пустой {@link ArrayList} банковских карт
     * @param user объект класса {@link User} - клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалять пользователя из списка
     * клиентов банка по паспортным данным
     * При удалении клиента создаётся новый объект класса User
     * с полученными паспортными данными и пустым именем
     * и происходит удаление по новому объекту
     * @param passport - паспортные данные
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавлять в список карт клиента новую карту
     * Поиск клиента осуществляется при помощи метода {@link BankService#findByPassport}
     * Если клиент найден и у него нет такой карты, то добавляется новый клиент к списку.
     * @param passport - паспортные данные
     * @param account - банковская карта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод выполняет поиск пользователя по паспортным данным
     * При помощи цикла for-each идёт перебор элементов списка ключей
     * и у каждого ключа, который является объектом класса {@link User}, вызывается
     * метод {@link User#getPassport()} и возвращенные паспортные данные сравниваются с входными данными
     * @param passport - паспортные данные в {@link String}
     * @return - возвращается объект класса {@link User} или null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод выполняет поиск карты по номеру карты
     * При помощи метода {@link BankService#findByPassport(String)} из списка клиентов находится нужный клиент
     * Далее при помощи цикла for-each идёт перебор списка карт данного пользователя и сравнение с искомым номером карты
     * @param passport - паспортные данные клиента, карту которого нужно вернуть
     * @param requisite - искомая карта клиента
     * @return - возвращается объект класса {@link Account}, содержащий данные об искомой карте
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (users.get(user) != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод выполняет перевод денежных средств с одной банковской карты на другую.
     * В ходе метода выполняется проверка существования используемых карт,
     * а также проверяется, достаточно ли денег для перевода на счёте отправителя
     * На вход принимаются:
     * @param sourcePassport - паспортные данные пользователя, со счета которого идёт списание
     * @param sourceRequisite - номер карты, с которой идёт списание
     * @param destinationPassport - паспортеые данные пользователя, счёт которого пополняется
     * @param destinationRequisite - номер карты, которая пополняется
     * @param amount - а также сумма перевода
     * @return - возвращается true или false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null
                && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список из счётов пользователя.
     * @param user - объект класса {@link User} - клиент, список счетов которого необходимо вернуть
     * @return - возвращается {@link List} счётов {@link Account} клиента
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
