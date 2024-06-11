package classes;

import java.util.HashMap;

public class Database {
    private static Database instance;
    private Database(){};
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    private HashMap<String, BankAccount> bankAccounts = new HashMap<String, BankAccount>();
    public void addAccount(BankAccount account) {
        bankAccounts.put(account.getPhoneNumber(), account);
    }

    public BankAccount getAccount(String phoneNumber) {
        return bankAccounts.get(phoneNumber);
    }

}
