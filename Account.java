public class Account
{
    private int key;
    private double balance;

    public Account(int accountNumber, double openingBalance)
    {
        key = accountNumber;
        balance = openingBalance;
    }

    public void setBalance(double amount)
    {
        // This can only be done as the Intent() method inverted amount on "w"
       balance += amount;
    }
    public double getBalance()
    {
        return balance;
    }
    public int getKey()
    {
        return key;
    }

}
