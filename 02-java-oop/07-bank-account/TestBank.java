public class TestBank 
{
    public static void main(String[] args)
    {
        BankAccount test = new BankAccount(3000, 1000);
        

        test.deposit(2000, "CHeckIng");
        test.getUserAccountTotal();
    }
}
