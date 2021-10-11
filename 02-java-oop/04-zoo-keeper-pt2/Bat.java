public class Bat extends Mammal
{
    public Bat(int energyLevel)
    {
        super(energyLevel);
    }

    public void fly()
    {
        System.out.println("Whoosh");
        energyLevel -= 50;
    }

    public void eatHumans()
    {
        System.out.println("Yum");
        energyLevel += 25;
    }

    public void attackTown()
    {
        System.out.println("*Town burning noises");
        energyLevel -= 100;
    }
}
