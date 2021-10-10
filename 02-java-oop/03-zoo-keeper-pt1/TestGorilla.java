public class TestGorilla 
{
    
    public static void main(String[] args)
    {
        Gorilla test = new Gorilla(100);

        for (int i = 0; i < 3; i++)
        {
            test.throwSomething();
        }

        test.displayEnergy();

        for (int i = 0; i < 2; i++)
        {
            test.eatBanana();
        }

        test.displayEnergy();

        test.climb();

        test.displayEnergy();

    }
}
