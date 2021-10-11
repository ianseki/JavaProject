public class BankAccount {
    
    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts = 0;
    private static double accountsTotal = 0;

    public BankAccount()
    {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        accountsTotal++;
    }

    public BankAccount(double checkingBalance, double savingsBalance)
    {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accountsTotal += (savingsBalance + checkingBalance);
        numOfAccounts++;
    }

    public static int accountCount()
    {
        return numOfAccounts;
    }

    public static double getAccountsTotal()
    {
        return accountsTotal;
    }

    public double getUserChecking()
    {
        return this.checkingBalance;
    }

    public double getUserSavings()
    {
        return this.savingsBalance;
    } 

    public void deposit(double newDeposit, String account)
    {
        account = account.toLowerCase();

        if (account.equals("checking"))
        {
            this.checkingBalance += newDeposit;
            accountsTotal += newDeposit;
        }

        else if (account.equals("savings"))
        {
            this.savingsBalance += newDeposit;
            accountsTotal += newDeposit;
        }
        
        else
        {
            System.out.println("Account type is incorrect. Please try again.");
        }
    }

    public void withdraw(double newWithdrawal, String account)
    {
        account = account.toLowerCase();

        if (account.equals("checking"))
        {
            if (newWithdrawal <= checkingBalance)
            {
                this.checkingBalance -= newWithdrawal;
                accountsTotal -= newWithdrawal;
            }
            else
            {
                System.out.println("Insufficient funds in checking account");
                System.out.println("Current savings: $" + this.getUserChecking());
            }
        }

        else if (account.equals("savings"))
        {
            if (newWithdrawal <= savingsBalance)
            {
                this.savingsBalance -= newWithdrawal;
                accountsTotal -= newWithdrawal;
            }
            else
            {
                System.out.println("Insufficient funds in savings account");
                System.out.println("Current savings: $" + this.getUserSavings());
            }
        }

        else
        {
            System.out.println("Account type is incorrect. Please try again.");
        }
    }

    public void getUserAccountTotal()
    {
        System.out.println("Your total in both checking and savings accounts: $" + (this.checkingBalance + this.savingsBalance));
    }
}
