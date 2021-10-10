public class Project 
{
    
    private String name;
    private String description;

    public void project()
    {
    }

    public void project(String name)
    {
        this.name = name;
    }

    public void project(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void elevatorPitch()
    {
        System.out.print(this.name + " : " + this.description);
    }
}
