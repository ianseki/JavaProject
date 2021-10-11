public class TestBat
{
    
    public static void main(String[] args)
    {
        Bat test = new Bat(300);

        test.displayEnergy();

        for (int i = 0; i < 2; i++)
        {
            test.attackTown();
        }

        test.displayEnergy();

        for (int i = 0; i < 3; i++)
        {
            test.eatHumans();
        }

        test.displayEnergy();

        for (int i = 0; i < 2; i++)
        {
            test.fly();
        }
        test.displayEnergy();

    }
}
