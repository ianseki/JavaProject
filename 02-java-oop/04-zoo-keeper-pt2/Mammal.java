public class Mammal {

    protected int energyLevel = 100;

    public Mammal(int energyLevel)
    {
        this.energyLevel = energyLevel;
    }

    public void setEnergyLevel(int energyLevel) 
    {
        this.energyLevel = energyLevel;
    }

    public int getEnergyLevel() 
    {
        return energyLevel;
    }

    public int displayEnergy()
    {
        System.out.println("Energy Level: " + this.energyLevel);

        return this.energyLevel;
    }

}
