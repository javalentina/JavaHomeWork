import java.math.BigDecimal;

public class Account {
    private Person person;
    private String iban;
    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "person=" + person +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(Person person, String iban, double balance) {
        this.person = person;
        this.iban = iban;
        this.balance = balance;
    }
}
