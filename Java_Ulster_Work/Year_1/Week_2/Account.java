package Week_2;

public class Account
{
    private double balance;
    private String name;
    private long acctNum;


    public Account(double initBal, String owner, long number)
    {
        this.balance = initBal;
        this.name = owner;
        this.acctNum = number;
    }

    public void withdraw(double amount)
    {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public double getBalance()
    {
        return balance;
    }

    public String toString()
    {
        return name + " " + String.valueOf(acctNum) + " " + String.valueOf(acctNum) ;
    }

    public void chargeFee(double ammount)
    {
        this.balance -= 100;
    }

    public void changeName(String newName)
    {

    }

}