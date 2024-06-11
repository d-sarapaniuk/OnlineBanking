package classes;

import java.util.HashMap;
import java.util.prefs.BackingStoreException;

public class Database {
    private static Database instance;
    private HashMap<String, BankAccount> bankAccounts = new HashMap<String, BankAccount>();

    private Database(){
        BankAccount testAccount = new BankAccount("1", "1", "1", "1", 12);
        bankAccounts.put(testAccount.getPhoneNumber(), testAccount);
    };
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public void addAccount(BankAccount account) {
        bankAccounts.put(account.getPhoneNumber(), account);
    }

    public BankAccount getAccount(String phoneNumber) {
        return bankAccounts.get(phoneNumber);
    }

}
