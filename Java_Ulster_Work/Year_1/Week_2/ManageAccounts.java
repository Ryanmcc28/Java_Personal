package Week_2;

public class ManageAccounts
{
    public static void main(String[] args)
    {


         Account acc1 = new Account(1000.0, "Sally", 1111);


        Account acc2 = new Account(5000.0, "Joe", 1112);

        //deposit $100 to Joe's account
        acc2.deposit(50);

        //print Joe's new balance (use getBalance())
        System.out.println(acc2.getBalance());

        //withdraw $50 from Sally's account
        acc1.chargeFee(50.0);

        //print Sally's new balance (use getBalance())
        System.out.println(acc1.getBalance());

        //charge fees to both accounts
        acc1.chargeFee(100.0);
        acc2.chargeFee(200.0);

        //change the name on Joe's account to Joseph
        acc2.changeName("Danny");
    }
}
