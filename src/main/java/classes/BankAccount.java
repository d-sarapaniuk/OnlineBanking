package classes;

public class BankAccount {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private double balance;

    public BankAccount(String firstName, String lastName, String phoneNumber, String password, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.balance = balance;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            toAccount.setBalance(toAccount.getBalance() + amount);
        }
    }
}
