package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mails = new HashMap<>();
        mails.put("328424", "Robert James");
        mails.put("238493", "Paul Monro");
        mails.put("203912", "Elizabeth Swan");
        for (String key : mails.keySet()) {
            System.out.println(mails.get(key));
        }
    }
}
